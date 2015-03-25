package com.asaas.pebble.spring.translate;

import static org.testng.Assert.assertEquals;

import org.springframework.test.context.ContextConfiguration;
import org.testng.annotations.Test;

import com.asaas.pebble.spring.translate.conf.TemplateLoaderTestConfig;

@Test
@ContextConfiguration(classes = TemplateLoaderTestConfig.class)
public class TemplateNameLookUpTest extends AbstractTest {

    public void testLazyLookUp() {
        String output = loadTemplate("look_up");
        assertEquals(output, "Look up");
    }

    public void testLazyLookUpInFolder() {
        String output = loadTemplate("folder/look_up_in_folder");
        assertEquals(output, "Look up in folder");
    }

    public void testLazyLookUpWithArgs() {
        String output = loadTemplate("folder/look_up_with_args");
        assertEquals(output, "Look up in (Arg1, Arg2)");
    }

    public void testPrivateLazyLookUpInFolder() {
        String output = loadTemplate("folder/_private_look_up_in_folder");
        assertEquals(output, "Private look up in folder");
    }

    public void testRootLazyLookUp() {
        String output = loadTemplate("folder/root_look_up");
        assertEquals(output, "Root look up");
    }

}
