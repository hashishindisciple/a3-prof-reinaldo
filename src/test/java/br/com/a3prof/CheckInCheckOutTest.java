package br.com.a3prof;

import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;

class CheckInCheckOutTest {

    // --- TESTES DE CHECK-IN (3 cenários) ---

    @Test
    void deveRealizarCheckInComSucessoCasoNormal() {
        CheckInCheckOut controle = new CheckInCheckOut();
        LocalDateTime entrada = LocalDateTime.of(2026, 11, 27, 14, 0);

        controle.realizarCheckIn(entrada);

        assertEquals(SituacaoHospedagem.CHECK_IN_REALIZADO, controle.getSituacao());
        assertEquals(entrada, controle.getDataHoraCheckIn());
    }

    @Test
    void deveRealizarCheckInNoHorarioLimiteExato() {
        CheckInCheckOut controle = new CheckInCheckOut();
        LocalDateTime limite = LocalDateTime.of(2026, 11, 27, 23, 59);

        controle.realizarCheckIn(limite);

        assertEquals(SituacaoHospedagem.CHECK_IN_REALIZADO, controle.getSituacao());
    }

    @Test
    void deveLancarErroAoRealizarCheckInDuplicadoOuNulo() {
        CheckInCheckOut controle = new CheckInCheckOut();
        assertThrows(NullPointerException.class, () -> controle.realizarCheckIn(null));

        controle.realizarCheckIn(LocalDateTime.now());
        assertThrows(IllegalStateException.class, () -> controle.realizarCheckIn(LocalDateTime.now()));
    }

    // --- TESTES DE CHECK-OUT (3 cenários) ---

    @Test
    void deveRealizarCheckOutComSucessoCasoNormal() {
        CheckInCheckOut controle = new CheckInCheckOut();
        LocalDateTime entrada = LocalDateTime.of(2026, 11, 27, 14, 0);
        LocalDateTime saida = LocalDateTime.of(2026, 11, 28, 12, 0);

        controle.realizarCheckIn(entrada);
        controle.realizarCheckOut(saida);

        assertEquals(SituacaoHospedagem.CHECK_OUT_REALIZADO, controle.getSituacao());
        assertEquals(saida, controle.getDataHoraCheckOut());
    }

    @Test
    void deveRealizarCheckOutNoMesmoInstanteDoCheckInValorLimite() {
        CheckInCheckOut controle = new CheckInCheckOut();
        LocalDateTime momento = LocalDateTime.of(2026, 11, 27, 14, 0);

        controle.realizarCheckIn(momento);
        controle.realizarCheckOut(momento);

        assertEquals(SituacaoHospedagem.CHECK_OUT_REALIZADO, controle.getSituacao());
    }

    @Test
    void deveLancarErroAoRealizarCheckOutSemCheckInOuDataAnterior() {
        CheckInCheckOut controle = new CheckInCheckOut();
        LocalDateTime entrada = LocalDateTime.of(2026, 11, 27, 14, 0);
        LocalDateTime saidaInvalida = LocalDateTime.of(2026, 11, 27, 13, 0);

        // Erro: check-out sem check-in
        assertThrows(IllegalStateException.class, () -> controle.realizarCheckOut(entrada));

        // Erro: data de saída anterior à entrada
        controle.realizarCheckIn(entrada);
        assertThrows(IllegalArgumentException.class, () -> controle.realizarCheckOut(saidaInvalida));
    }
}