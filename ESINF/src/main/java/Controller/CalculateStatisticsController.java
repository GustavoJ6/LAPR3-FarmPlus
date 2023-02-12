package Controller;

import Domain.*;
import Domain.Products.*;
import Functionalities.CalculateStatistics;
import Miscellaneous.*;

import java.util.*;

public class CalculateStatisticsController {

    private CalculateStatistics calculator;
    private final DistributionNetworkData data;

    /**
     * Instantiates a new Calculate statistics controller.
     */
    public CalculateStatisticsController() {
        data = App.getInstance().getSystemData();
    }

    /**
     * Calculates the statistics.
     *
     * @param dispatchList the dispatch list
     */
    public void calculateStatistics(List<BasketOrder> dispatchList) {
        calculator = new CalculateStatistics(dispatchList);
        calculator.calculateStatistics();
    }

    /**
     * Calculates statistics.
     *
     * @param index the index
     */
    public void calculateStatistics(int index, boolean isSimple) {
        List<BasketOrder> dispatchList = isSimple ? data.getSimpleDispatchLists().get(index) : data.getDispatchListsWithRestrictions().get(index);
        calculator = new CalculateStatistics(dispatchList);
        calculator.calculateStatistics();
    }

    /**
     * Gets basket order statistics.
     *
     * @return the basket order statistics
     */
    public List<BasketOrderStatistics> getBasketOrderStatistics() { return calculator.getBasketOrderStatistics(); }

    /**
     * Gets client statistics.
     *
     * @return the client statistics
     */
    public Collection<ClientStatistics> getClientStatistics() {
        return calculator.getClientStatistics();
    }

    /**
     * Gets producers statistics.
     *
     * @return the producers statistics
     */
    public Collection<ProducerStatistics> getProducersStatistics() {
        return calculator.getProducerStatistics();
    }

    /**
     * Gets producer statistics.
     *
     * @return the producer statistics
     */
    public Collection<ProducerStatistics> getProducerStatistics() { return calculator.getProducerStatistics(); }

    /**
     * Gets hub statistics.
     *
     * @return the hub statistics
     */
    public Collection<HubStatistics> getHubStatistics() {
        return calculator.getMapHubStats();
    }


    /**
     * Gets simple dispatch list to print.
     *
     * @return the simple dispatch list to print
     */
    public List<String> getSimpleDispatchListToPrint() {
        List<String> dispatchLists = new ArrayList<>();
        for (int i = 0; i < data.getSimpleDispatchLists().size(); i++)
            dispatchLists.add("Dispatch List " + i);
        return dispatchLists;
    }

    /**
     * Gets dispatch list with restriction to print.
     *
     * @return the dispatch list with restriction to print
     */
    public List<String> getDispatchListWithRestrictionToPrint() {
        List<String> dispatchLists = new ArrayList<>();
        for (int i = 0; i < data.getDispatchListsWithRestrictions().size(); i++)
            dispatchLists.add("Dispatch List " + i);
        return dispatchLists;
    }
}
