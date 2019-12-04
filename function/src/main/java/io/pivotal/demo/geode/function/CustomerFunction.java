package io.pivotal.demo.geode.function;

import io.pivotal.demo.geode.function.model.Customer;
import lombok.extern.log4j.Log4j2;
import org.apache.geode.cache.Region;
import org.apache.geode.cache.execute.Function;
import org.apache.geode.cache.execute.FunctionContext;
import org.apache.geode.cache.execute.RegionFunctionContext;
import org.apache.geode.cache.partition.PartitionRegionHelper;
import org.apache.geode.pdx.PdxInstance;

import java.util.Collections;
import java.util.Iterator;
import java.util.Objects;
import java.util.stream.Collectors;

@Log4j2
public class CustomerFunction implements Function {
    @Override
    public void execute(FunctionContext context) {
        RegionFunctionContext regionFunctionContext = (RegionFunctionContext) context;

        Iterator<String> iterator = Collections.emptyIterator();

        if (!regionFunctionContext.getFilter().isEmpty()) {
            Region<String, PdxInstance> customerRegion = PartitionRegionHelper
                    .getLocalDataForContext(regionFunctionContext);

            iterator = customerRegion
                    .getAll(regionFunctionContext.getFilter())
                    .values()
                    .stream()
                    .filter(Objects::nonNull)
                    .map(Customer::new)
                    .map(this::getInfo)
                    .collect(Collectors.toList())
                    .iterator();
        }

        sendResults(iterator, context);
    }

    private String getInfo(Customer customer) {
        return "name: " + customer.getFirstName() + " " + customer.getLastName() + " " +
                "dob: " + (customer.getDob() == null ? "unknown" : customer.getDob().toString());
    }

    private void sendResults(Iterator<String> iterator, FunctionContext context) {
        if (!iterator.hasNext()) {
            context.getResultSender().lastResult(null);
        }

        while (iterator.hasNext()) {
            String result = iterator.next();
            if (iterator.hasNext()) {
                context.getResultSender().sendResult(result);
            } else {
                context.getResultSender().lastResult(result);
            }
        }
    }
}
