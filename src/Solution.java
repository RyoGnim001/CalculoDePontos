import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public int calPoints(String[] operations) {
        Deque<Integer> minhaPilha = new ArrayDeque<Integer>();

        for (String op : operations) {
            if (op.equals("+")) {
                int fimDaPilha = minhaPilha.pop();
                int novoTopo = minhaPilha.peek();
                minhaPilha.push(fimDaPilha);
                minhaPilha.push(fimDaPilha + novoTopo);
            } else if (op.equals("D")) {
                minhaPilha.push(minhaPilha.peek() * 2);
            } else if (op.equals("C")) {
                minhaPilha.pop();
            } else {
                minhaPilha.push(Integer.parseInt(op));
            }
        }

        int soma = 0;
        for (int pontuacao : minhaPilha) {
            soma += pontuacao;
        }
        return soma;
    }
}
