package k06_asyncs;

import lombok.extern.slf4j.Slf4j;
import lombok.val;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Slf4j
public class AsyncJava {
    void runnable() {
        if (new Random().nextBoolean()) {
            log.info("you are lucky!");
        } else {
            throw new IllegalArgumentException("you are unlucky!");
        }
    }

    int expensive() {
        return new Random().nextInt();
    }

    int next(int i) {
        return i * i;
    }

    void example() {
        try {
            val runnable = CompletableFuture.runAsync(this::runnable);
            log.info("started runnable");
            runnable.get();

            val expensive = CompletableFuture.supplyAsync(this::expensive)
                    .thenApply(this::next)
                    .thenApply(i -> {
                        log.info("Done processing");
                        return i;
                    });
            log.info("started expensive");
            val result = expensive.get();
            log.info("result {}", result);

        } catch (InterruptedException e) {
            log.error("Thread was interrupted", e);
        } catch (ExecutionException e) {
            if (e.getCause() instanceof IllegalArgumentException) {
                log.error(e.getCause().getMessage());
            } else {
                log.error("Anything could've happen", e);
            }
        }

    }
}
