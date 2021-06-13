package com.xzinoviou.cqrs.service.query;

import com.xzinoviou.cqrs.domain.jpa.Account;
import com.xzinoviou.cqrs.domain.query.AccountQuery;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.axonframework.messaging.Message;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.stereotype.Service;

/**
 * @author : Xenofon Zinoviou
 */
@Service
public class AccountQueryServiceImpl implements AccountQueryService {

  private final QueryGateway queryGateway;
  private final EventStore eventStore;

  public AccountQueryServiceImpl(QueryGateway queryGateway,
                                 EventStore eventStore) {
    this.queryGateway = queryGateway;
    this.eventStore = eventStore;
  }

  @Override
  public CompletableFuture<Account> getAccountById(String accountId) {
    return queryGateway.query(
        AccountQuery.builder()
            .accountId(accountId)
            .build(),
        ResponseTypes.instanceOf(Account.class)
    );
  }

  @Override
  public List<Object> getAllEventsByAccountId(String accountId) {
    return eventStore.readEvents(accountId)
        .asStream()
        .map(Message::getPayload)
        .collect(Collectors.toList());
  }
}
