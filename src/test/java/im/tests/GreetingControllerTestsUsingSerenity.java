/**
 * @author IM
 *
 * Adding two tests here to check if our webservice is working as expected.
 *
 * I think SpringBoot is used for integration testing. Please check this tomo.
 */
package im.tests;

import im.learn.Application;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.junit.spring.integration.SpringIntegrationClassRule;
import net.serenitybdd.junit.spring.integration.SpringIntegrationMethodRule;

import net.serenitybdd.junit.spring.integration.SpringIntegrationSerenityRunner;
import org.junit.ClassRule;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SerenityRunner.class)
//@ContextConfiguration(classes = Application.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
//@SpringBootTest(classes = Application.class)
//@AutoConfigureMockMvc
public class GreetingControllerTestsUsingSerenity {

    @ClassRule
    public static SpringIntegrationClassRule springIntegrationClassRule = new SpringIntegrationClassRule();

//    @Rule
//    public SpringIntegrationMethodRule springIntegrationMethodRule = new SpringIntegrationMethodRule();

    @Autowired
    private MockMvc mockMvc;

    @DirtiesContext

    @Test
    public void noParamGreetingShouldReturnDefaultMessage() throws Exception {

        this.mockMvc.perform(get("/greeting")).andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.content").value("Hello, World!"));
    }

    @Test
    public void paramGreetingShouldReturnTailoredMessage() throws Exception {

        this.mockMvc.perform(get("/greeting").param("name", "Vocalink Offshore"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.content").value("Hello, Vocalink Offshore!"));
    }

}
