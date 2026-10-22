package com.info.arvorebinaria.controller;

import com.info.arvorebinaria.model.enums.OrderEnum;
import com.info.arvorebinaria.model.request.ElementoRequest;
import com.info.arvorebinaria.model.response.MessageResponse;
import com.info.arvorebinaria.model.response.OrdenacaoResponse;
import com.info.arvorebinaria.service.NoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/no")
public class NoController {

    @Autowired
    private NoService noService;

    @PostMapping()
    public ResponseEntity<MessageResponse> insere(@RequestBody ElementoRequest request){
        noService.insere(request.getElemento());
        return ResponseEntity.ok(new MessageResponse("Elemento adicionado!"));
    }

    @DeleteMapping()
    public ResponseEntity<MessageResponse> limpa(){
        noService.limpa();
        return ResponseEntity.ok(new MessageResponse("Árvore limpa!"));
    }

    @GetMapping()
    public ResponseEntity<OrdenacaoResponse> ordem(@RequestParam("order") OrderEnum.Order order){
        return ResponseEntity.ok(noService.order(order));
    }


}
