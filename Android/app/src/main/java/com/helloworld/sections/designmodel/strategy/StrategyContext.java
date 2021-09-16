package com.helloworld.sections.designmodel.strategy;

public class StrategyContext
{
    private  FightingStrategy fightingStrategy;

    public StrategyContext(FightingStrategy fightingStrategy) {
        this.fightingStrategy = fightingStrategy;
    }
    public  void  fighting () {
        fightingStrategy.finghting();
    }
}
