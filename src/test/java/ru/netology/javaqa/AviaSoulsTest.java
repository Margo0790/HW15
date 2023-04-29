package ru.netology.javaqa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

public class AviaSoulsTest {
    @Test
    public void shouldSortTicketsByPrice() {
        AviaSouls aviaSouls = new AviaSouls();

        Ticket ticket1 = new Ticket("DXB", "ORC", 1000, 10, 12);
        Ticket ticket2 = new Ticket("LAX", "DOH", 3500, 18, 12);
        Ticket ticket3 = new Ticket("NCE", "MIA", 2300, 17, 8);
        Ticket ticket4 = new Ticket("EVN", "CDG", 500, 23, 12);
        Ticket ticket5 = new Ticket("LAX", "DOH", 3000, 2, 18);
        Ticket ticket6 = new Ticket("MLE", "DXB", 4000, 3, 10);
        Ticket ticket7 = new Ticket("EVN", "LED", 500, 1, 5);
        Ticket ticket8 = new Ticket("LAX", "DOH", 3900, 2, 18);

        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);
        aviaSouls.add(ticket6);
        aviaSouls.add(ticket7);
        aviaSouls.add(ticket8);

        Ticket[] expected = {ticket5, ticket2, ticket8};
        Ticket[] actual = aviaSouls.search("LAX", "DOH");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindWithComparator() {
        AviaSouls aviaSouls = new AviaSouls();

        Ticket ticket1 = new Ticket("DXB", "ORC", 1000, 10, 12);
        Ticket ticket2 = new Ticket("LAX", "DOH", 3500, 18, 12);
        Ticket ticket3 = new Ticket("NCE", "MIA", 2300, 17, 8);
        Ticket ticket4 = new Ticket("EVN", "CDG", 500, 00, 12);
        Ticket ticket5 = new Ticket("LAX", "DOH", 3000, 2, 18);
        Ticket ticket6 = new Ticket("MLE", "DXB", 4000, 3, 10);
        Ticket ticket7 = new Ticket("EVN", "LED", 500, 1, 5);
        Ticket ticket8 = new Ticket("LAX", "DOH", 3900, 2, 18);

        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);
        aviaSouls.add(ticket6);
        aviaSouls.add(ticket7);
        aviaSouls.add(ticket8);

        Ticket[] expected = {ticket1, ticket6};
        Ticket[] actual = aviaSouls.search("LAX", "DOH");

        Assertions.assertEquals(1, ticket6.compareTo(ticket2));
        Assertions.assertEquals(0, ticket1.compareTo(ticket1));
        Assertions.assertEquals(-1, ticket3.compareTo(ticket5));
    }

    @Test
    public void shouldFindComparator() {
        AviaSouls aviaSouls = new AviaSouls();

        Ticket ticket1 = new Ticket("DXB", "ORC", 1000, 10, 12);
        Ticket ticket2 = new Ticket("LAX", "DOH", 3500, 8, 12);
        Ticket ticket3 = new Ticket("NCE", "MIA", 2300, 17, 8);
        Ticket ticket4 = new Ticket("EVN", "CDG", 500, 23, 12);
        Ticket ticket5 = new Ticket("LAX", "DOH", 3000, 2, 18);
        Ticket ticket6 = new Ticket("MLE", "DXB", 4000, 3, 10);
        Ticket ticket7 = new Ticket("EVN", "LED", 500, 1, 5);
        Ticket ticket8 = new Ticket("LAX", "DOH", 3900, 2, 15);

        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);
        aviaSouls.add(ticket6);
        aviaSouls.add(ticket7);
        aviaSouls.add(ticket8);

        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] expected = {ticket2, ticket8, ticket5};
        Ticket[] actual = aviaSouls.searchByTime("LAX", "DOH", comparator);

        Assertions.assertArrayEquals(expected, actual);
    }
}
