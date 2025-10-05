package core.mate.academy.service;

import core.mate.academy.model.Bulldozer;
import core.mate.academy.model.Excavator;
import core.mate.academy.model.Machine;
import core.mate.academy.model.Truck;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Your implementation of MachineService.
 */
public class MachineServiceImpl<T extends Machine> implements MachineService<T> {
    @Override
    public List<T> getAll(Class<? extends T> type) {
        if (type == Truck.class) {
            TruckProducer producer = new TruckProducer();
            List<Truck> trucks = producer.get();
            return (List<T>) new ArrayList<>(trucks);
        }
        if (type == Bulldozer.class) {
            BulldozerProducer producer = new BulldozerProducer();
            List<Bulldozer> bulldozers = producer.get();
            return (List<T>) new ArrayList<>(bulldozers);
        }
        if (type == Excavator.class) {
            ExcavatorProducer producer = new ExcavatorProducer();
            List<Excavator> excavators = producer.get();
            return (List<T>) new ArrayList<>(excavators);
        }
        return Collections.emptyList();
    }

    @Override
    public void fill(List<? super T> machines, T value) {
        for (int i = 0; i < machines.size(); i++) {
            machines.set(i, value);
        }
    }

    @Override
    public void startWorking(List<? extends T> machines) {
        for (T machine : machines) {
            machine.doWork();
        }
    }
}
