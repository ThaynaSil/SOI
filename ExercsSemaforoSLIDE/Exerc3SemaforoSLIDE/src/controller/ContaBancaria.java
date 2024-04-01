package controller;

import java.util.Random;

public class ContaBancaria {
 private int codigoConta;
 private double saldo;

 public ContaBancaria(int codigoConta, double saldo) {
     this.codigoConta = codigoConta;
     this.saldo = saldo;
 }

 public synchronized void sacar(double valor) {
     if (saldo >= valor) {
         saldo -= valor;
         System.out.println("Saque de R$" + valor + " realizado na conta " + codigoConta + ". Saldo restante: R$" + saldo);
     } else {
         System.out.println("Saldo insuficiente para realizar o saque na conta " + codigoConta);
     }
 }

 public synchronized void depositar(double valor) {
     saldo += valor;
     System.out.println("Deposito de R$" + valor + " realizado na conta " + codigoConta + ". Saldo atual: R$" + saldo);
 }
}
