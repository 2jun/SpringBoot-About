/*
 * Copyright 2016-2018 shardingsphere.io.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * </p>
 */

package com.mkeeper.service;

import com.mkeeper.entity.Order;
import com.mkeeper.entity.OrderItem;
import com.mkeeper.entity.Stock;
import com.mkeeper.mapper.OrderItemMapper;
import com.mkeeper.mapper.OrderMapper;
import com.mkeeper.mapper.StockMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class DemoService {
    
    @Resource
    private OrderMapper orderMapper;

    @Resource
    private StockMapper stockMapper;
    
    @Resource
    private OrderItemMapper orderItemMapper;
    
    public void demo() {
        for (int i = 1; i <= 10; i++) {

            Stock stock = new Stock();
            stock.setId(i);
            stock.setName("name " + i);
            stockMapper.insert(stock);

            Order order = new Order();
            order.setUserId(51 + i);
            order.setStatus("INSERT_TEST");
            orderMapper.insert(order);
            long orderId = order.getOrderId();

            OrderItem item = new OrderItem();
            item.setOrderId(orderId);
            item.setUserId(51 + i);
            orderItemMapper.insert(item);
        }
        System.out.println(orderItemMapper.selectAll());
    }
}
