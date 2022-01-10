import java.util.List;
import java.util.stream.Collectors;

public class Service {
    /**
     *
     * @param list
     * @return
     */

    public List<Orders> sortOrdersByTotalPrice(List<Orders> list) {
        return list.stream()
                .sorted((order, otherOrder) -> order.getTotalPrice() - otherOrder.getTotalPrice())
                .collect(Collectors.toList());
    }

}
