package br.com.a3prof;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.assertTrue;

class AppTest {
    @Test
    void encerraPeloMenu() {
        String saida = executar("0\n");
        assertTrue(saida.contains("HOTEL"), saida);
    }

    @Test
    void executaCrudDeHospede() {
        String entradas = "1\nAna\n12345678909\n31999999999\na@exemplo.com\n"
                + "3\n12345678909\nAna Silva\n31988887777\na@exemplo.com\n"
                + "2\n4\n12345678909\n4\n12345678909\n0\n";
        String saida = executar(entradas);
        assertTrue(saida.contains("Ana Silva"), saida);
        assertTrue(saida.contains("Registro nao encontrado"), saida);
    }

    @Test
    void criaReservaComHospedeEQuarto() {
        String entradas = "1\nAna\n12345678909\n31999999999\na@exemplo.com\n"
                + "5\n101\nSimples\n150\n9\n1\n12345678909\n101\n"
                + "2026-12-01\n2026-12-03\n7\n101\nSimples\n200\nDisponivel\n"
                + "11\n1\n2026-12-01\n2026-12-03\n10\n0\n";
        String saida = executar(entradas);
        assertTrue(saida.contains("Ana | quarto 101"), saida);
        assertTrue(saida.contains("total 300"), saida);
    }

    private String executar(String entradas) {
        var entradaOriginal = System.in;
        var saidaOriginal = System.out;
        var buffer = new ByteArrayOutputStream();
        try {
            System.setIn(new ByteArrayInputStream(entradas.getBytes(StandardCharsets.UTF_8)));
            System.setOut(new PrintStream(buffer, true, StandardCharsets.UTF_8));
            App.main(new String[0]);
            return buffer.toString(StandardCharsets.UTF_8);
        } finally {
            System.setIn(entradaOriginal);
            System.setOut(saidaOriginal);
        }
    }
}
