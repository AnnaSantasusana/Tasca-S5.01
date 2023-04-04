package cat.itacademy.barcelonactiva.santasusana.anna.s05.t01.n03.controllers;

import cat.itacademy.barcelonactiva.santasusana.anna.s05.t01.n03.model.dto.FlowerDTO;
import cat.itacademy.barcelonactiva.santasusana.anna.s05.t01.n03.model.dto.Message;
import cat.itacademy.barcelonactiva.santasusana.anna.s05.t01.n03.model.exceptions.FlowerNotFoundException;
import cat.itacademy.barcelonactiva.santasusana.anna.s05.t01.n03.model.services.IClientFlowerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@Tag(name = "Flowers Management System with WebClient", description = "Reactive RESTful API connected to another RESTful API")
@RequestMapping("/flowers")
public class ClientFlowerController {

    @Autowired
    IClientFlowerService flowerService;

    @GetMapping("/clientFlowersGetOne/{pk_FlowerID}")
    @Operation( summary = "Read a flower from the database",
                description = "Get an existing flower",
                responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Flower updated correctly",
                            content = {@Content(mediaType = "application/json", schema = @Schema(implementation = FlowerDTO.class))}),
                    @ApiResponse(
                            responseCode = "500",
                            description = "Internal Server Error",
                            content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Message.class))}),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Flower Not Found",
                            content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Message.class))})})

    public ResponseEntity<Mono<FlowerDTO>> getFlower(@PathVariable("pk_FlowerID") int pk_FlowerID) throws Exception {
        try {
            return ResponseEntity.ok(flowerService.getFlowerById(pk_FlowerID));
        } catch (FlowerNotFoundException e) {
            throw e;
        } catch (Exception e) {
            throw new Exception("Error while getting flower", e);
        }
    }

    @GetMapping("/clientFlowersAll")
    @Operation( summary = "Read a list of flower from the database",
                description = "Get all flowers from the database",
                responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Flower updated correctly",
                            content = {@Content(mediaType = "application/json", schema = @Schema(implementation = FlowerDTO.class))}),
                    @ApiResponse(
                            responseCode = "500",
                            description = "Internal Server Error",
                            content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Message.class))}),
                    @ApiResponse(
                            responseCode = "404",
                            description = "There are no flowers into the database",
                            content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Message.class))})})

    public ResponseEntity<Flux<FlowerDTO>> getAllFlowers() throws Exception {
        try {
            return ResponseEntity.ok(flowerService.listFlowers());
        } catch (FlowerNotFoundException e) {
            throw e;
        } catch (Exception e) {
            throw new Exception("Error while getting flowers", e);
        }
    }

    @PostMapping("/clientFlowersAdd")
    @Operation( summary = "Create a new flower into the database",
                description = "Adds a new flower",
                responses = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "Flower created correctly",
                            content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Message.class))}),
                    @ApiResponse(
                            responseCode = "500",
                            description = "Internal Server Error",
                            content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Message.class))}),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Bad Request",
                            content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Message.class))})})

    public ResponseEntity<Mono<Message>> addFlower(@Valid @RequestBody FlowerDTO flower) throws Exception {
        try {
            return ResponseEntity.ok(flowerService.saveFlower(flower));
        } catch (Exception e) {
            throw new Exception("Error while adding flower", e);
        }
    }

    @DeleteMapping("/clientFlowersDelete/{pk_FlowerID}")
    @Operation( summary = "Delete a flower from the database",
                description = "Delete an existing flower",
                responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Flower deleted correctly",
                            content = {@Content(schema = @Schema(implementation = Message.class))}),
                    @ApiResponse(
                            responseCode = "500",
                            description = "Internal Server Error",
                            content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Message.class))}),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Flower Not Found",
                            content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Message.class))})})

    public ResponseEntity<Mono<Message>> deleteFlower(@PathVariable("pk_FlowerID") int pk_FlowerID) throws Exception {
        try {
            return ResponseEntity.ok(flowerService.deleteFlower(pk_FlowerID));
        } catch (FlowerNotFoundException e) {
            throw e;
        } catch (Exception e) {
            throw new Exception("Error while deleting flower", e);
        }
    }

    @PutMapping("/clientFlowersUpdate/{pk_FlowerID}")
    @Operation( summary = "Update a flower from the database",
                description = "Update an existing flower",
                responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Flower updated correctly",
                            content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Message.class))}),
                    @ApiResponse(
                            responseCode = "500",
                            description = "Internal Server Error",
                            content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Message.class))}),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Bad Request",
                            content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Message.class))}),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Flower Not Found",
                            content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Message.class))})})

    public ResponseEntity<Mono<Message>> updateFlower(@PathVariable("pk_FlowerID") int pk_FlowerID,
                                                      @Valid @RequestBody FlowerDTO flower) throws Exception {
        try {
            return ResponseEntity.ok(flowerService.updateFlower(pk_FlowerID, flower));
        } catch (FlowerNotFoundException e) {
            throw e;
        } catch (Exception e) {
            throw new Exception("Error while updating flower", e);
        }
    }

}

