package com.lomoye.learnGoava.orderingSection;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.google.common.collect.Ordering;
import com.lomoye.learnGoava.functionSection.FluentIterable;


import java.util.List;

/**
 * Created by lomoye on 2017/8/2.
 * 排序器篇章
 */
public class OrderingSection {

    public static void main(String[] args) {
        test1();
    }









    static void test1() {
        List<Domain> domains = mockDomains();

        Ordering<Domain> ordering = buildOrdering();

        domains = ordering.sortedCopy(domains);

        for (Domain domain : domains) {
            System.out.println(domain.getId() + "|" + domain.getLevel());
        }
    }

    private static Ordering<Domain> buildOrdering() {
        Ordering<Domain> idOrdering = Ordering.natural().onResultOf(new Function<Domain, Comparable>() {
            public Comparable apply(Domain input) {
                return input.getId();
            }
        });

        Ordering<Domain> levelOrdering = Ordering.natural().onResultOf(new Function<Domain, Comparable>() {
            public Comparable apply(Domain domain) {
                return domain.getLevel();
            }
        });

        return idOrdering.compound(levelOrdering.reverse());
    }

    private static List<Domain> mockDomains() {
        List<Domain> domains = Lists.newArrayList();
        domains.add(new Domain.DomainBuilder().setId(3L).setLevel(2L).build());
        domains.add(new Domain.DomainBuilder().setId(2L).setLevel(1L).build());
        domains.add(new Domain.DomainBuilder().setId(1L).setLevel(2L).build());
        domains.add(new Domain.DomainBuilder().setId(2L).setLevel(9L).build());
        domains.add(new Domain.DomainBuilder().setId(2L).setLevel(6L).build());
        domains.add(new Domain.DomainBuilder().setId(2L).setLevel(5L).build());
        domains.add(new Domain.DomainBuilder().setId(2L).setLevel(8L).build());
        domains.add(new Domain.DomainBuilder().setId(2L).setLevel(7L).build());

        return domains;
    }
}
