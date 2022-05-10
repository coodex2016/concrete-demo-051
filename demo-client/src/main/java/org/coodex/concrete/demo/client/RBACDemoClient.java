package org.coodex.concrete.demo.client;


import lombok.extern.slf4j.Slf4j;
import org.coodex.concrete.Client;
import org.coodex.concrete.ClientException;
import org.coodex.concrete.demo.api.excepted.DemoLoginService;
import org.coodex.concrete.demo.api.excepted.LibraryA;
import org.coodex.concrete.demo.api.excepted.LibraryB;

@Slf4j
public class RBACDemoClient {
    private static void demoA() {
        LibraryA library = Client.getInstance(LibraryA.class, "demoModule");
        library.delete("A1");
        library.sort();
        library.delete("A2");
    }

    private static void demoB() {
        LibraryB library = Client.getInstance(LibraryB.class, "demoModule");
        library.delete("B1");
        library.sort();
        library.delete("B2");
    }

    public static void main(String[] args) {
        String[] users = new String[]{
                "A", "B", "C", "D"
        };
        for (String s : users) {
            try {
                DemoLoginService demoLoginService = Client.getInstance(DemoLoginService.class, "demoModule");
                demoLoginService.login(s);
                try {
                    demoA();
                } catch (ClientException e) {
                    log.info("demoA [user: {}] error: {}, {}", s, e.getCode(), e.getMessage());
                }

                try {
                    demoB();
                } catch (ClientException e) {
                    log.info("demoB [user: {}] error: {}, {}", s, e.getCode(), e.getMessage());
                }
            } catch (ClientException e) {
                log.info("login failed: {}", e.getLocalizedMessage());
            }
        }
    }
}