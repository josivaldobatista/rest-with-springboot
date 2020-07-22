package br.com.jfb;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

  private static final String TEMPLATE = "Hello, %s!";
  private final AtomicLong COUNTER = new AtomicLong();

  @RequestMapping("/greetings")
  public Greeting greeting(@RequestParam(value = "nome", defaultValue = "World") String nome) {
    return new Greeting(COUNTER.incrementAndGet(), String.format(TEMPLATE, nome));
  }
}