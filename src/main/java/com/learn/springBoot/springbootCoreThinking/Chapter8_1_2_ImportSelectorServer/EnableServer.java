package com.learn.springBoot.springbootCoreThinking.Chapter8_1_2_ImportSelectorServer;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

import static org.bouncycastle.crypto.tls.ConnectionEnd.server;

/**
 * @author lyh on 2019/6/8
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(ServerImportSelect.class)
public @interface EnableServer {
    Server.Type type();
}
