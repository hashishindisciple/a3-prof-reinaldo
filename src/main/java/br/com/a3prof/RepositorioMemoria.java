package br.com.a3prof;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class RepositorioMemoria<K, V> {
    private final Map<K, V> registros = new LinkedHashMap<>();

    public boolean cadastrar(K chave, V registro) {
        Objects.requireNonNull(chave, "Chave obrigatoria");
        Objects.requireNonNull(registro, "Registro obrigatorio");
        return registros.putIfAbsent(chave, registro) == null;
    }

    public V buscar(K chave) {
        return registros.get(Objects.requireNonNull(chave, "Chave obrigatoria"));
    }

    public List<V> listar() {
        return List.copyOf(registros.values());
    }

    public boolean atualizar(K chave, V registro) {
        Objects.requireNonNull(chave, "Chave obrigatoria");
        Objects.requireNonNull(registro, "Registro obrigatorio");
        if (!registros.containsKey(chave)) return false;
        registros.put(chave, registro);
        return true;
    }

    public boolean excluir(K chave) {
        return registros.remove(Objects.requireNonNull(chave, "Chave obrigatoria")) != null;
    }
}
