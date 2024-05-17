package com.phoebus.service.ServiceImpl;

import com.phoebus.entites.ItemPedido;
import com.phoebus.exception.ItemDoPedidoException;
import io.micronaut.core.annotation.NonNull;

import java.util.List;
import java.util.Optional;

public interface ItemDoPedidoServiceImpl {

    List<ItemPedido> listAll();

    ItemPedido save(ItemPedido itemPedido);

    Optional<ItemPedido> findById(@NonNull Long id) throws ItemDoPedidoException;

    void deletById (Long id) throws ItemDoPedidoException;
}
