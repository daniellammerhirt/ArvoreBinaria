package com.info.arvorebinaria.service;

import com.info.arvorebinaria.model.db.No;
import com.info.arvorebinaria.model.enums.OrderEnum;
import com.info.arvorebinaria.model.response.OrdenacaoResponse;
import org.springframework.stereotype.Service;

@Service
public class NoService {

    private static No topo;

    public NoService(){
        topo = null;
    }

    public void limpa(){
        topo = null;
    }

    public void cria(Integer elem){
        topo = new No(elem);
    }

    public void insere(Integer elemento){
        if(topo == null){
            cria(elemento);
        }else{
            insere(elemento, topo);
        }
    }

    public No insere(Integer elemento, No no){
        No outroNo;
        if ( no != null){
            if (elemento < no.getNumero()){
                outroNo = insere(elemento, no.getEsquerda());
                no.setEsquerda(outroNo);
            }else {
                outroNo = insere(elemento, no.getDireita());
                no.setDireita(outroNo);
            }
        }else {
            return new No(elemento);
        }
        return no;
    }


    public Boolean busca(No no, Integer elem){
        if (no == null)
            return false;
        else
            if (no.getNumero() > elem)
                return busca(no.getEsquerda(), elem);
            else
                if (no.getNumero() < elem)
                    return busca(no.getDireita(), elem);
                else
                    return true;
    }

    public OrdenacaoResponse order(OrderEnum.Order order){
        return switch (order){
            case POS -> pos();
            case IN -> in();
            case PRE -> pre();
        };
    }

    public OrdenacaoResponse pre(){
        if(topo == null){
            return new OrdenacaoResponse(OrderEnum.Order.PRE, "");
        }

        return new OrdenacaoResponse(OrderEnum.Order.PRE,  pre(topo, ""));
    }

    public String pre(No no, String resultado){
        resultado += no.getNumero() + " ";

        if(no.getEsquerda() != null){
            resultado = pos(no.getEsquerda(), resultado);
        }

        if(no.getDireita() != null){
            resultado = pos(no.getDireita(), resultado);
        }



        return resultado;
    }

    public OrdenacaoResponse pos(){
        if(topo == null){
            return new OrdenacaoResponse(OrderEnum.Order.POS, "");
        }

        return new OrdenacaoResponse(OrderEnum.Order.POS,  pos(topo, ""));
    }

    public String pos(No no, String resultado){
        if(no.getEsquerda() != null){
            resultado = pos(no.getEsquerda(), resultado);
        }

        if(no.getDireita() != null){
            resultado = pos(no.getDireita(), resultado);
        }

        resultado += no.getNumero() + " ";

        return resultado;
    }

    public OrdenacaoResponse in(){
        if(topo == null){
            return new OrdenacaoResponse(OrderEnum.Order.IN, "");
        }

        return new OrdenacaoResponse(OrderEnum.Order.IN,  in(topo, ""));
    }

    public String in(No no, String resultado){
        if(no.getEsquerda() != null){
            resultado = pos(no.getEsquerda(), resultado);
        }

        resultado += no.getNumero() + " ";

        if(no.getDireita() != null){
            resultado = pos(no.getDireita(), resultado);
        }

        return resultado;
    }
}
