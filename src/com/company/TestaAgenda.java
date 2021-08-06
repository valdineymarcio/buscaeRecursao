package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class TestaAgenda {

    public static void main(String[] args) throws IOException {
        Agenda ag = new Agenda();
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));

        int numContatosASeremAdd,numContatoASeremBuscados;
        numContatosASeremAdd=Integer.parseInt(bf.readLine());
        String nome;
        Long telContato;
        Long telBuscar;

        System.out.println();

        while (numContatosASeremAdd>0){
            nome= bf.readLine();
            telContato=Long.parseLong(bf.readLine());
            ag.addContato(nome,telContato);
            numContatosASeremAdd--;


        }

        numContatoASeremBuscados=Integer.parseInt(bf.readLine());

        while (numContatoASeremBuscados>0){
                telBuscar=Long.parseLong(bf.readLine());
            ag.buscaIterativaSequencial(telBuscar);
            ag.buscaRecursivaSequencial(telBuscar, 0);
            ag.buscaIterativaBinaria(telBuscar);
            ag.buscaRecursivaBinaria(telBuscar, 0, ag.getQuantidade()-1);
            numContatoASeremBuscados--;

        }


    }
}