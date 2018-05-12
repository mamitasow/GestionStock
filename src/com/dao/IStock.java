package com.dao;

import java.util.List;

import com.entite.Stock;

public interface IStock {
public int add(Stock stock);
public int update(Stock stock);
public Stock get(int ref);
public List<Stock> liste();
public int delete(int ref);
}
