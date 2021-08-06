package com.company;

public class Agenda {
    private int quantidade;
    private Contato[] listaDeContatos;
   private Contato[] copia=new Contato[20];



    public int getQuantidade() {
        return quantidade;
    }

    public Agenda() {
        this.quantidade = 0;
        this.listaDeContatos = new Contato[20];

    }

    public void addContato(String nome, long telefone) {
        Contato c1 = new Contato(nome, telefone);
        for(int i=0;i< listaDeContatos.length;i++){
            if(this.listaDeContatos[i]==null){
                this.listaDeContatos[i]=c1;


            this.quantidade++ ;
            break;
            }
        }
    }

    public int buscaIterativaSequencial(long telefone) {

        int i=0 ;
        boolean encontrado = false;
        while (i<quantidade && !encontrado){
            if(this.listaDeContatos[i].getTelefone() == telefone){
                System.out.println("Contato encotrado na posiçao " + i + " ! " );
                System.out.println(listaDeContatos[i].getNome());
                System.out.println(listaDeContatos[i].getTelefone());
                encontrado= true;
                break;

            } else{
                i++;
            }
            if(i==quantidade && !encontrado){
                System.out.println("Contato nao encontrado!");
            }

            }

        return -1;
    }



    public int buscaRecursivaSequencial(long telefone, int indice) {

        if(indice<quantidade){
            if(listaDeContatos[indice].getTelefone()==telefone){
                System.out.println("Contato encontrado na posicao " + indice +"!");
                System.out.println(listaDeContatos[indice].getNome());
                System.out.println(listaDeContatos[indice].getTelefone());
                return indice;
            }else{
                return buscaRecursivaSequencial(telefone,indice+1);
            }

        }
        System.out.println("Contato nao encontrado ! ");
        return -1; //se não encontrar o contato buscado
    }

    public int buscaIterativaBinaria(long telefone) {
        ordenarVetor();
        int esquerda=0;
        int meio;
        int direita= quantidade-1;

        while (esquerda<= direita){
            meio = (esquerda+direita)/2;
            if(copia[meio].getTelefone()==telefone) {
                System.out.println("Contato encontrado na posicao " + meio+ "!" );
                System.out.println(copia[meio].getNome());
                System.out.println(copia[meio].getTelefone());
                return meio;
            }else if (copia[meio].getTelefone()< telefone){
                esquerda=meio+1;

            }else{
                direita=meio-1;
            }
        }
        System.out.println("Contato nao encontrado!");
        return -1;
    }

    public int buscaRecursivaBinaria(long telefone, int esquerda, int direita) {
        ordenarVetor();
        int meio = (direita + esquerda) / 2;
        if (esquerda > direita) {
            System.out.println("Contato nao encontrado!");
            return -1;//se não encontrar o contato buscado

        } else if (copia[meio].getTelefone() == telefone) {
            System.out.println("Contato encontrado na posicao " + meio +"!");
            System.out.println(copia[meio].getNome());
            System.out.println(copia[meio].getTelefone());
        } else if (copia[meio].getTelefone() < telefone) {
            return buscaRecursivaBinaria(telefone, meio+1, direita);
        } else {
            return buscaRecursivaBinaria(telefone, esquerda, meio-1);
        }

    return -1;
    }
    public void ordenarVetor() {
        for (int i = 0; i < quantidade; i++) {
            copia[i] = listaDeContatos[i];
        }
        for (int i = 0; i < quantidade - 1; i++) {
            for (int j = 0; j < quantidade - 1 - i; j++) {
                if (copia[j].getTelefone() > copia[j + 1].getTelefone()) {
                    Contato auxiliar = copia[j];
                    copia[j] = copia[j + 1];
                    copia[j + 1] = auxiliar;
                }
            }
        }


    }









}
