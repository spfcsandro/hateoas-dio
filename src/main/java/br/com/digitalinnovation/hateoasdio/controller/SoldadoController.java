package br.com.digitalinnovation.hateoasdio.controller;

import br.com.digitalinnovation.hateoasdio.controller.response.SoldadoListResponse;
import br.com.digitalinnovation.hateoasdio.controller.response.SoldadoResponse;
import br.com.digitalinnovation.hateoasdio.dto.SoldadoDTO;
import br.com.digitalinnovation.hateoasdio.controller.request.SoldadoEditRequest;
import br.com.digitalinnovation.hateoasdio.model.Soldado;
import br.com.digitalinnovation.hateoasdio.repository.SoldadoRepository;
import br.com.digitalinnovation.hateoasdio.service.SoldadoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1/soldado")
public class SoldadoController {

    private SoldadoService soldadoService;

    public SoldadoController(SoldadoService soldadoService) {
        this.soldadoService = soldadoService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<SoldadoResponse> buscarSoldado(@PathVariable("id") Long id){
        SoldadoResponse soldadoResponse = soldadoService.buscarSoldado(id);
        return ResponseEntity.status(HttpStatus.OK).body(soldadoResponse);
    }

    @PostMapping
    public ResponseEntity criarSoldado(@RequestBody SoldadoDTO soldadoDTO){
        soldadoService.criarSoldado(soldadoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity editarSoldado(@PathVariable("id") Long id,
                                        @RequestBody SoldadoEditRequest soldadoEditRequest){
        soldadoService.editarSoldado(id, soldadoEditRequest);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletarSoldado(@PathVariable("id") Long id){
        soldadoService.deletarSoldado(id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/frente-castelo/{id}")
    public ResponseEntity frenteCastelo(@PathVariable("id") Long id){
        //Fazer algo
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<CollectionModel<SoldadoListResponse>> buscarSoldados(){
        CollectionModel<SoldadoListResponse> soldadoListResponses = soldadoService.buscarSoldados();
        return ResponseEntity.status(HttpStatus.OK).body(soldadoListResponses);
    }
}
