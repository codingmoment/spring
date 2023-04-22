package com.spring.miscellaneous.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.IntStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.miscellaneous.service.AsyncService;

@RestController
@RequestMapping("/misc/async")
public class AsyncController {

  private static final Logger LOGGER = LoggerFactory.getLogger(AsyncController.class);

  @Autowired
  private AsyncService asyncService;

  @PostMapping("/nowait")
  public void startInBackgroundAndForget() {
    LOGGER.info("startInBackground started...");

    try {
      asyncService.runInBackground(1);
      asyncService.runInBackground(2);
      asyncService.runInBackground(3);
      asyncService.runInBackground(4);
      asyncService.runInBackground(5);
    }
    catch (InterruptedException e) {
    }

    LOGGER.info("startInBackground completed...");
  }

  @PostMapping("/wait")
  public void startInBackgroundAndWait() {
    LOGGER.info("startInBackground started...");
    try {
      CompletableFuture<Void> future1 = asyncService.runInBackgroundAndReturnFuture(1);
      CompletableFuture<Void> future2 = asyncService.runInBackgroundAndReturnFuture(2);
      CompletableFuture<Void> future3 = asyncService.runInBackgroundAndReturnFuture(3);
      CompletableFuture<Void> future4 = asyncService.runInBackgroundAndReturnFuture(4);
      CompletableFuture<Void> future5 = asyncService.runInBackgroundAndReturnFuture(5);

      CompletableFuture.allOf(future1, future2, future3, future4, future5).join();
    }
    catch (InterruptedException e) {
    }
    LOGGER.info("startInBackground completed...");
  }

}
