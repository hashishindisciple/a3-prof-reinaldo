package br.com.a3prof;


import java.time.LocalDateTime;
import java.util.Objects;

public class CheckInCheckOut {

    private SituacaoHospedagem situacao;
    private LocalDateTime dataHoraCheckIn;
    private LocalDateTime dataHoraCheckOut;

    public CheckInCheckOut() {
        this.situacao = SituacaoHospedagem.RESERVADA;
    }

    public void realizarCheckIn(LocalDateTime momentoCheckIn) {
        validarCheckIn(momentoCheckIn);
        this.dataHoraCheckIn = momentoCheckIn;
        this.situacao = SituacaoHospedagem.CHECK_IN_REALIZADO;
    }

    public void realizarCheckOut(LocalDateTime momentoCheckOut) {
        validarCheckOut(momentoCheckOut);
        this.dataHoraCheckOut = momentoCheckOut;
        this.situacao = SituacaoHospedagem.CHECK_OUT_REALIZADO;
    }

    private void validarCheckIn(LocalDateTime momentoCheckIn) {
        Objects.requireNonNull(momentoCheckIn, "Data/hora do check-in não pode ser nula");
        if (this.situacao != SituacaoHospedagem.RESERVADA) {
            throw new IllegalStateException("Check-in só é permitido para hospedagem RESERVADA");
        }
    }

    private void validarCheckOut(LocalDateTime momentoCheckOut) {
        Objects.requireNonNull(momentoCheckOut, "Data/hora do check-out não pode ser nula");
        if (!isHospedado()) {
            throw new IllegalStateException("Check-out só é permitido após o check-in");
        }
        if (this.dataHoraCheckIn != null && momentoCheckOut.isBefore(this.dataHoraCheckIn)) {
            throw new IllegalArgumentException("Check-out não pode ser anterior ao check-in");
        }
    }

    public boolean isHospedado() {
        return this.situacao == SituacaoHospedagem.CHECK_IN_REALIZADO;
    }

    public SituacaoHospedagem getSituacao() {
        return situacao;
    }

    public LocalDateTime getDataHoraCheckIn() {
        return dataHoraCheckIn;
    }

    public LocalDateTime getDataHoraCheckOut() {
        return dataHoraCheckOut;
    }
}