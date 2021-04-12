package com.example.demo.controller.dto;

import com.example.demo.entites.*;

import java.util.stream.Collectors;

/**
 * Converter class with static methods
 * used to convert from dto and to dto objects
 *
 * @version 1.0
 */
public class DtoConverter {
    //TODO add methods to convert to dto
    //TODO refactor controllers to use dto for front end
    public static Component fromDto(DtoComponent dtoComponent) {
        if (dtoComponent instanceof DtoCooler) {
            DtoCooler dto = (DtoCooler) dtoComponent;
            Cooler component = new Cooler();
            component.setId(dto.getId());
            component.setName(dto.getName());
            component.setCompany(dto.getCompany());
            component.setPrice(dto.getPrice());
            component.setCoolingCapacity(dto.getCoolingCapacity());
            return component;
        }
        if (dtoComponent instanceof DtoCPU) {
            DtoCPU dto = (DtoCPU) dtoComponent;
            CPU component = new CPU();
            component.setId(dto.getId());
            component.setName(dto.getName());
            component.setCompany(dto.getCompany());
            component.setPrice(dto.getPrice());
            component.setCoreCount(dto.getCoreCount());
            component.setFrequency(dto.getFrequency());
            return component;
        }
        if (dtoComponent instanceof DtoDataStorageDevice) {
            DtoDataStorageDevice dto = (DtoDataStorageDevice) dtoComponent;
            DataStorageDevice component = new DataStorageDevice();
            component.setId(dto.getId());
            component.setName(dto.getName());
            component.setCompany(dto.getCompany());
            component.setPrice(dto.getPrice());
            component.setType(dto.getType());
            component.setCapacity(dto.getCapacity());
            return component;
        }
        if (dtoComponent instanceof DtoMotherboard) {
            DtoMotherboard dto = (DtoMotherboard) dtoComponent;
            Motherboard component = new Motherboard();
            component.setId(dtoComponent.getId());
            component.setName(dto.getName());
            component.setCompany(dto.getCompany());
            component.setPrice(dto.getPrice());
            component.setRamSlotsCount(dto.getRamSlots());
            return component;
        }
        if (dtoComponent instanceof DtoPowerSupply) {
            DtoPowerSupply dto = (DtoPowerSupply) dtoComponent;
            PowerSupply component = new PowerSupply();
            component.setId(dto.getId());
            component.setName(dto.getName());
            component.setCompany(dto.getCompany());
            component.setPrice(dto.getPrice());
            component.setCapacity(dto.getCapacity());
            return component;
        }
        if (dtoComponent instanceof DtoRAM) {
            DtoRAM dto = (DtoRAM) dtoComponent;
            RAM component = new RAM();
            component.setId(dto.getId());
            component.setName(dto.getName());
            component.setCompany(dto.getCompany());
            component.setPrice(dto.getPrice());
            component.setCapacity(dto.getCapacity());
            return component;
        }
        if (dtoComponent instanceof DtoVideoCard) {
            DtoVideoCard dto = (DtoVideoCard) dtoComponent;
            VideoCard component = new VideoCard();
            component.setId(dto.getId());
            component.setName(dto.getName());
            component.setCompany(dto.getCompany());
            component.setPrice(dto.getPrice());
            component.setGpuSpeed(dto.getGpuSpeed());
            return component;
        }

        return new Cooler();
    }

    public static Order fromDto(DtoOrder dtoOrder) {
        Order order = new Order();
        order.setId(dtoOrder.getId());
        order.setComponents(dtoOrder.getComponents().stream().map(DtoConverter::fromDto).collect(Collectors.toList()));
        order.setJustification(dtoOrder.getJustification());
        order.setRegistrationDate(dtoOrder.getRegistrationDate());
        return order;
    }
}
