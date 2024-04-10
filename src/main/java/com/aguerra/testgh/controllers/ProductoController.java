package com.aguerra.testgh.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aguerra.testgh.dto.ProductoRequest;
import com.aguerra.testgh.dto.ProductoResponse;
import com.aguerra.testgh.service.ProductoService;
import com.aguerra.testgh.util.Constantes;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * Clases que implementan los controladores REST
 * 
 * @author Angel Guerra
 */
@RestController
@Tag(name = "Producto", description = "Producto APIs")
@RequestMapping("/api/v1/product")
public class ProductoController {
	
	private static final Logger logger = LoggerFactory.getLogger(ProductoController.class);
	
	@Autowired
	ProductoService productoService;

	@Operation(
	      summary = "Endpoint para crear Producto",
	      description = "Endpoint ejecuta un SP que registra el producto en la BD de Oracle y retorna los productos registrados en el día a través de un cursor."
	      )
	@ApiResponses({
	      @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = ProductoResponse.class), mediaType = "application/json") }),
	      @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema(implementation = ProductoResponse.class), mediaType = "application/json") })
	})
    @PostMapping()
    public ResponseEntity<ProductoResponse> registrarProducto(@RequestBody ProductoRequest productoRequest) {
    	
		logger.info("Request -> " + productoRequest.toString());
    	
    	ProductoResponse response = productoService.insertarProducto(productoRequest);
    	
		logger.info("Response -> " + response.toString());

    	if(!response.getCodRespuesta().equals(Constantes.DB_COD_OK)) {
            return ResponseEntity.internalServerError().body(response);
    	}
    	
        return ResponseEntity.ok(response);
    }
}
