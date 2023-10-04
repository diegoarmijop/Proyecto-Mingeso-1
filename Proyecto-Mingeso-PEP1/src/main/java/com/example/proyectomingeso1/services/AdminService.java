package com.example.proyectomingeso1.services;

import com.example.proyectomingeso1.entities.EstudianteEntity;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    //Calcula el descuento según el tipo de pago
    //CONTADO: 50% de descuento; caso contrario 0%
    public double calcularDescuentoPorTipoPago(EstudianteEntity estudiante){
        double descuentoPorTipoPago = 0;
        if(estudiante.getTipoPago() == "CONTADO"){
            descuentoPorTipoPago = 0.5;
        }else{
            return descuentoPorTipoPago;
        }
        return descuentoPorTipoPago;
    }

    //Calcula el descuento según el tipo de colegio
    //MUNICIPAL: 20% de descuento
    //SUBVENCIONADO: 10% de descuento
    //PRIVADO: 0% de descuento
    public double calcularDescuentoPorTipoColegio(EstudianteEntity estudiante){
        double descuentoPorTipoColegio = 0;
        if(estudiante.getTipoColegioProcedencia() == "MUNICIPAL"){
            descuentoPorTipoColegio = 0.2;
        } else if (estudiante.getTipoColegioProcedencia() == "SUBVENCIONADO") {
            descuentoPorTipoColegio = 0.1;
        }else {
            return descuentoPorTipoColegio;
        }
        return descuentoPorTipoColegio;
    }

    public double calcularValorPorCuota(EstudianteEntity estudiante){
        double descuentoTotal = calcularDescuentoPorTipoPago(estudiante) +
                calcularDescuentoPorTipoColegio(estudiante);
        double valorPorCuota = (1500000 - 1500000*descuentoTotal)/estudiante.getTipoPago();
        return valorPorCuota;
    }
}
