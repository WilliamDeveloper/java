package br.com.core.string;

public class DataValidade {

    private int dia, mes, ano;

    public DataValidade() {
    }

    public DataValidade(int dia, int mes, int ano) {
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }
  
    public int getDia() {
        return this.dia;
    }

    public int getMes() {
        return this.mes;
    }

    public int getAno() {
        return this.ano;
    }
  
    public void setDia(int dia) {
        this.dia = dia;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String toString() {
        return this.dia + "/" + this.mes + "/" + this.ano;
    }

    public boolean validarData(int dia, int mes, int ano) {
        if (ano > 0) {
            switch (mes) {
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                    if (dia <= 31) {
                        return true;
                    }
                    break;
                case 2:                    
                    if ((ano % 400 == 0) || ((ano % 4 == 0) && (ano %100 !=0))) {
                        if (dia <= 29) {
                            return true;
                        }
                    } else if (dia <= 28) {
                        return true;
                    }
                    break;
                case 4:
                case 6:
                case 9:
                case 11:
                    if (dia <= 30) {
                        return true;
                    }
                    break;
                default:
                    break;
            }
        }
        return false;
    }

}
