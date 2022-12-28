package com.pet.petmanagement;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.pet.petmanagement.business.login.CreatePetJson;
import com.pet.petmanagement.business.login.ManagementService;
import com.pet.petmanagement.domain.pet.Pet;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import javax.annotation.Resource;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(properties = {
        "spring.jpa.hibernate.ddl-auto=update",
        "spring.liquibase.enabled=true",
        "spring.flyway.enabled=false"
})
@AutoConfigureMockMvc
class ManagementServiceIntegrationTest {

    @Resource
    private MockMvc mockMvc;

    @Resource
    private ObjectMapper objectMapper;

    @Resource
    private ManagementService managementService;

    @Test
    void success_addNewPet() throws Exception {
        CreatePetJson json = new CreatePetJson();
        json.setPetName("Sassu");
        json.setPetCode("123456");
        json.setType("DOG");
        json.setColor("BLACK");
        json.setCountry("ESTONIA");

        mockMvc.perform(post("/users/{userId}/pets", 1)
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(json)))
                .andExpect(status().isOk());

        List<Pet> allPetsByUserId = managementService.getAllPetsByUserId(1);
        assertFalse(allPetsByUserId.isEmpty());
        assertEquals("ESTONIA", allPetsByUserId.get(0).getCountry());
        assertEquals("Sassu", allPetsByUserId.get(0).getName());
        assertEquals("DOG", allPetsByUserId.get(0).getType());
        assertEquals("BLACK", allPetsByUserId.get(0).getColor());
        assertEquals("123456", allPetsByUserId.get(0).getCode());
        assertEquals(1, allPetsByUserId.get(0).getUser().getId());
    }

    @Test
    void unsuccess_addNewPetWithMissingName() throws Exception {
        CreatePetJson json = new CreatePetJson();
        json.setPetCode("123456");
        json.setType("DOG");
        json.setColor("BLACK");
        json.setCountry("ESTONIA");

        mockMvc.perform(post("/users/{userId}/pets", 1)
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(json)))
                .andExpect(status().is4xxClientError());

        List<Pet> allPetsByUserId = managementService.getAllPetsByUserId(1);
        assertTrue(allPetsByUserId.isEmpty());
    }

    @Test
    void unsuccess_addNewPetWithNotExistingUser() throws Exception {
        CreatePetJson json = new CreatePetJson();
        json.setPetName("Sassu");
        json.setPetCode("123456");
        json.setType("DOG");
        json.setColor("BLACK");
        json.setCountry("ESTONIA");

        mockMvc.perform(post("/users/{userId}/pets", 10)
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(json)))
                .andExpect(status().is4xxClientError());

        List<Pet> allPetsByUserId = managementService.getAllPetsByUserId(1);
        assertTrue(allPetsByUserId.isEmpty());
    }

    @Test
    void unsuccess_addNewPetWithEmptyName() throws Exception {
        CreatePetJson json = new CreatePetJson();
        json.setPetName("");
        json.setPetCode("123456");
        json.setType("DOG");
        json.setColor("BLACK");
        json.setCountry("ESTONIA");

        mockMvc.perform(post("/users/{userId}/pets", 1)
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(json)))
                .andExpect(status().is4xxClientError());

        List<Pet> allPetsByUserId = managementService.getAllPetsByUserId(1);
        assertTrue(allPetsByUserId.isEmpty());

    }

    @Test
    void unsuccess_addNewPetWithCodeOnlySpaces() throws Exception {
        CreatePetJson json = new CreatePetJson();
        json.setPetName("Sassu");
        json.setPetCode("      ");
        json.setType("DOG");
        json.setColor("BLACK");
        json.setCountry("ESTONIA");

        mockMvc.perform(post("/users/{userId}/pets", 1)
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(json)))
                .andExpect(status().is4xxClientError());

        List<Pet> allPetsByUserId = managementService.getAllPetsByUserId(1);
        assertTrue(allPetsByUserId.isEmpty());
    }
    @Test
    void unsuccess_addNewPetWithMissingCode() throws Exception {
        CreatePetJson json = new CreatePetJson();
        json.setPetName("Sassu");
        json.setType("DOG");
        json.setColor("BLACK");
        json.setCountry("ESTONIA");

        mockMvc.perform(post("/users/{userId}/pets", 1)
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(json)))
                .andExpect(status().is4xxClientError());

        List<Pet> allPetsByUserId = managementService.getAllPetsByUserId(1);
        assertTrue(allPetsByUserId.isEmpty());

    }

    @Test
    void unsuccess_addNewPetWithEmptyCode() throws Exception {
        CreatePetJson json = new CreatePetJson();
        json.setPetName("Sassu");
        json.setPetCode("");
        json.setType("DOG");
        json.setColor("BLACK");
        json.setCountry("ESTONIA");

        mockMvc.perform(post("/users/{userId}/pets", 1)
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(json)))
                .andExpect(status().is4xxClientError());

        List<Pet> allPetsByUserId = managementService.getAllPetsByUserId(1);
        assertTrue(allPetsByUserId.isEmpty());

    }

    @Test
    void unsuccess_addNewPetWithTooShortCode() throws Exception {
        CreatePetJson json = new CreatePetJson();
        json.setPetName("Sassu");
        json.setPetCode("123");
        json.setType("DOG");
        json.setColor("BLACK");
        json.setCountry("ESTONIA");

        mockMvc.perform(post("/users/{userId}/pets", 1)
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(json)))
                .andExpect(status().isBadRequest());

        List<Pet> allPetsByUserId = managementService.getAllPetsByUserId(1);
        assertTrue(allPetsByUserId.isEmpty());

    }

    @Test
    void unsuccess_addNewPetWithMissingType() throws Exception {
        CreatePetJson json = new CreatePetJson();
        json.setPetName("Sassu");
        json.setPetCode("123456");
        json.setColor("BLACK");
        json.setCountry("ESTONIA");

        mockMvc.perform(post("/users/{userId}/pets", 1)
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(json)))
                .andExpect(status().is4xxClientError());

        List<Pet> allPetsByUserId = managementService.getAllPetsByUserId(1);
        assertTrue(allPetsByUserId.isEmpty());

    }

    @Test
    void unsuccess_addNewPetWithEmptyType() throws Exception {
        CreatePetJson json = new CreatePetJson();
        json.setPetName("Sassu");
        json.setPetCode("123456");
        json.setType("");
        json.setColor("BLACK");
        json.setCountry("ESTONIA");

        mockMvc.perform(post("/users/{userId}/pets", 1)
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(json)))
                .andExpect(status().is4xxClientError());

        List<Pet> allPetsByUserId = managementService.getAllPetsByUserId(1);
        assertTrue(allPetsByUserId.isEmpty());

    }

    @Test
    void unsuccess_addNewPetWithMissingColor() throws Exception {
        CreatePetJson json = new CreatePetJson();
        json.setPetName("Sassu");
        json.setPetCode("123456");
        json.setType("DOG");
        json.setCountry("ESTONIA");

        mockMvc.perform(post("/users/{userId}/pets", 1)
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(json)))
                .andExpect(status().is4xxClientError());

        List<Pet> allPetsByUserId = managementService.getAllPetsByUserId(1);
        assertTrue(allPetsByUserId.isEmpty());

    }


    @Test
    void unsuccess_addNewPetWithEmptyColor() throws Exception {
        CreatePetJson json = new CreatePetJson();
        json.setPetName("Sassu");
        json.setPetCode("123456");
        json.setType("DOG");
        json.setColor("");
        json.setCountry("ESTONIA");

        mockMvc.perform(post("/users/{userId}/pets", 1)
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(json)))
                .andExpect(status().is4xxClientError());

        List<Pet> allPetsByUserId = managementService.getAllPetsByUserId(1);
        assertTrue(allPetsByUserId.isEmpty());
    }

    @Test
    void unsuccess_addNewPetWithMissingCountry() throws Exception {
        CreatePetJson json = new CreatePetJson();
        json.setPetName("Sassu");
        json.setPetCode("123456");
        json.setType("DOG");
        json.setColor("BLACK");

        mockMvc.perform(post("/users/{userId}/pets", 1)
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(json)))
                .andExpect(status().is4xxClientError());

        List<Pet> allPetsByUserId = managementService.getAllPetsByUserId(1);
        assertTrue(allPetsByUserId.isEmpty());

    }

    @Test
    void unsuccess_addNewPetWithEmptyCountry() throws Exception {
        CreatePetJson json = new CreatePetJson();
        json.setPetName("Sassu");
        json.setPetCode("123456");
        json.setType("DOG");
        json.setColor("BLACK");
        json.setCountry("");

        mockMvc.perform(post("/users/{userId}/pets", 1)
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(json)))
                .andExpect(status().is4xxClientError());

        List<Pet> allPetsByUserId = managementService.getAllPetsByUserId(1);
        assertTrue(allPetsByUserId.isEmpty());

    }


}