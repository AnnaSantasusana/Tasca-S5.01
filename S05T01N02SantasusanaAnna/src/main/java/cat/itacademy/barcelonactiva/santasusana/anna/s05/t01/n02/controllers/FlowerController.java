package cat.itacademy.barcelonactiva.santasusana.anna.s05.t01.n02.controllers;

import cat.itacademy.barcelonactiva.santasusana.anna.s05.t01.n02.model.dto.FlowerDTO;
import cat.itacademy.barcelonactiva.santasusana.anna.s05.t01.n02.model.dto.Message;
import cat.itacademy.barcelonactiva.santasusana.anna.s05.t01.n02.model.exceptions.FlowerNotFoundException;
import cat.itacademy.barcelonactiva.santasusana.anna.s05.t01.n02.model.services.IFlowerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/flowers")
@Tag(name = "Flowers Management System", description = "CRUD operations from flowers database")
public class FlowerController {

    @Autowired
    private IFlowerService flowerService;

    @PostMapping("/add")
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

    public ResponseEntity<Message> addFlower(@Valid @RequestBody FlowerDTO flower, WebRequest request) throws Exception {
        try {
            flowerService.saveFlower(flower);
            Message message = new Message(HttpStatus.CREATED.value(), new Date(), "Flower added correctly", request.getDescription(false));
            return new ResponseEntity<>(message, HttpStatus.CREATED);
        } catch (Exception e) {
            throw new Exception("Error while adding flower", e);
        }
    }

    @PutMapping("/update/{pk_FlowerID}")
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

    public ResponseEntity<Message> updateFlower(@Parameter(description = "Flower's id") @PathVariable("pk_FlowerID") int pk_FlowerID,
                                                @Valid @RequestBody FlowerDTO flower, WebRequest request) throws Exception {
        try {
            FlowerDTO f = flowerService.getFlowerDTOById(pk_FlowerID);
            f.setNameFlower(flower.getNameFlower());
            f.setCountryFlower(flower.getCountryFlower());
            flowerService.saveFlower(f);
            Message message = new Message(HttpStatus.OK.value(), new Date(), "Flower updated correctly", request.getDescription(false));
            return new ResponseEntity<>(message, HttpStatus.OK);
        } catch (FlowerNotFoundException e) {
            throw e;
        } catch (Exception e) {
            throw new Exception("Error while updating flower", e);
        }
    }

    @DeleteMapping("/delete/{pk_FlowerID}")
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

    public ResponseEntity<Message> deleteFlower(@Parameter(description = "Flower's id") @PathVariable("pk_FlowerID") int pk_FlowerID, WebRequest request) throws Exception {

        try {
            flowerService.deleteFlower(pk_FlowerID);
            Message message = new Message(HttpStatus.OK.value(), new Date(), "Flower removed correctly", request.getDescription(false));
            return new ResponseEntity<>(message, HttpStatus.OK);
        } catch (FlowerNotFoundException e) {
            throw e;
        } catch (Exception e) {
            throw new Exception("Error while removing flower", e);
        }
    }

    @GetMapping("/getOne/{pk_FlowerID}")
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

    public ResponseEntity<FlowerDTO> getFlower(@Parameter(description = "Flower's id") @PathVariable("pk_FlowerID") int pk_FlowerID) throws Exception {

        try {
            FlowerDTO flower = flowerService.getFlowerDTOById(pk_FlowerID);
            return new ResponseEntity<>(flower, HttpStatus.OK);
        } catch (FlowerNotFoundException e) {
            throw e;
        } catch (Exception e) {
            throw new Exception("Error while getting flower", e);
        }
    }

    @GetMapping("/getAll")
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
    public ResponseEntity<List<FlowerDTO>> getAllFlowers() throws Exception {

        try {
            List<FlowerDTO> flowers = flowerService.listFlowers();
            return new ResponseEntity<>(flowers, HttpStatus.OK);
        } catch (FlowerNotFoundException e) {
            throw e;
        } catch (Exception e) {
            throw new Exception("Error while getting flowers", e);
        }
    }


}
