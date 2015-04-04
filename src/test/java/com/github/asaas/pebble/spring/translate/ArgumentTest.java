package com.github.asaas.pebble.spring.translate;

import static org.testng.Assert.assertEquals;

import org.springframework.test.context.ContextConfiguration;
import org.testng.annotations.Test;

import com.github.asaas.pebble.spring.translate.conf.StringLoaderTestConfig;

@Test
@ContextConfiguration(classes = StringLoaderTestConfig.class)
public class ArgumentTest extends AbstractTest {

    public void testOneArg() {
        String output = loadTemplate("{{ t('argumeant.one', \"I'm arg\") }}");
        assertEquals(output, "One arg is: I'm arg!");
    }

    public void testMultipleArgs() {
        String output = loadTemplate("{{ t('argumeant.multiple', 'arg1', 'arg2', 'arg3') }}");
        assertEquals(output, "First arg1, second arg2, third arg3");
    }

    public void testNumber() {
        String output = loadTemplate("{{ t('argumeant.number', 1) }}");
        assertEquals(output, "Number: 1!");
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testWithoutArgs() {
        loadTemplate("{{ t() }}");
    }
}
