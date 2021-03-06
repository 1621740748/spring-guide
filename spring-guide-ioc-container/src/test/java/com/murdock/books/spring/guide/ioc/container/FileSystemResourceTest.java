package com.murdock.books.spring.guide.ioc.container;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author weipeng2k 2018年09月24日 下午16:33:23
 */
public class FileSystemResourceTest {

    @Test
    public void file_system_resource() {
        Resource resource = new FileSystemResource("conf/file1.txt");
        Assert.assertFalse(resource.exists());

        resource = new FileSystemResource(
                "/Users/weipeng2k/Documents/workspace/spring-guide/spring-guide-ioc-container/src/test/resources/conf/file1.txt");

        Assert.assertTrue(resource.exists());
    }

    @Test
    public void props() throws IOException {
        Resource resource = new FileSystemResource(
                "/Users/weipeng2k/Documents/workspace/spring-guide/spring-guide-ioc-container/src/test/resources/conf/file1.txt");

        System.out.println("resource.getDescription() = " + resource.getDescription());
        System.out.println("resource.getFilename() = " + resource.getFilename());
        System.out.println("resource.contentLength() = " + resource.contentLength());
    }

    @Test
    public void read() throws IOException {
        Resource resource = new FileSystemResource(
                "/Users/weipeng2k/Documents/workspace/spring-guide/spring-guide-ioc-container/src/test/resources/conf/file1.txt");

        BufferedReader br = new BufferedReader(new InputStreamReader(resource.getInputStream()));
        Assert.assertEquals("a=b", br.readLine());
    }

}
