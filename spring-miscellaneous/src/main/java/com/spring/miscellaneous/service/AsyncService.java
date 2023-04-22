package com.spring.miscellaneous.service;

import java.util.concurrent.CompletableFuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class AsyncService {

  private static final Logger LOGGER = LoggerFactory.getLogger(AsyncService.class);

  /**
   * @formatter:off
   * 
   * One approach to scale the services is to run expensive jobs in the background.
   * 
   * The annotation @Async indicates that the method should run on a separate thread.
   * The return type of the method should be either void or Future.
   * 
   * @formatter:on
   */
  @Async
  public void runInBackground(int taskNumber) throws InterruptedException {
    LOGGER.info("Running task {} in background ...", taskNumber);
    Thread.sleep(5000L);
  }

  @Async("MyAsyncExecutor")
  public CompletableFuture<Void> runInBackgroundAndReturnFuture(int taskNumber) throws InterruptedException {
    LOGGER.info("Running task {} in background ...", taskNumber);
    Thread.sleep(5000L);
    return CompletableFuture.completedFuture(null);
  }

}
