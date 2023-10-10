package org.caesar.util.strategy;

import org.caesar.common.util.StatusMap;

import java.util.List;

//范围匹配，只要结果在一定范围内即可，适用于结果为浮点数的题目
//TODO: 新增题目时校验特殊题目类型的输出用例
public class RoundStrategy implements JudgeStrategy {

    private RoundStrategy(){}

    private static class InnerHolder {
        private static final RoundStrategy SINGLETON = new RoundStrategy();
    }

    public static RoundStrategy getInstance() {
        return InnerHolder.SINGLETON;
    }

    @Override
    public StatusMap judge(List<String> codeResult, List<String> outputCase) {

        int size = codeResult.size();
        StatusMap map = new StatusMap(size);

        for (int i = 0; i < size; i++) {

            double result = Double.parseDouble(codeResult.get(i));

            String[] params = outputCase.get(i).split(" ");
            double min = Double.parseDouble(params[0]);
            double max = Double.parseDouble(params[1]);

            if(result < min || result > max)
                map.setFail(i);
        }

        return map;
    }

    //参数必须是两个double类型的数据
    @Override
    public boolean testOutputCase(List<String> outputCase) {

        try {
            for (int i = 0; i < outputCase.size(); i++) {
                String[] params = outputCase.get(i).split(" ");
                if(params.length != 2)
                    return false;

                Double.parseDouble(params[0]);
                Double.parseDouble(params[1]);
            }
        } catch (NumberFormatException e) {
            return false;
        }

        return true;
    }

    @Override
    public String generateAnswer(String outputCase) {
        return outputCase.split(" ")[0];
    }
}
