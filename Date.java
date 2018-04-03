/**
 *
 * @author Rodri Feles
 */
public class Date {
    private int _dia;
    private int _mes;
    private int _anyo;
    private final String nombreMeses[] = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
    private final String nombresSemana[] = {"Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado", "Domingo"};
    private final int diasMesesNoBi[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private final int diasMesesBi[] = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    
    public Date(){
        _dia = 1;
        _mes = 1;
        _anyo = 2000;
    }
    public Date(int dia, int mes, int anyo){
        this._dia = dia;
        this._mes = mes;
        this._anyo = anyo;
    }
    public int getYear(){
        return this._anyo;
    }
    public int getMonth(){
        return this._mes;
    }
    public int getDay(){
        return this._dia;
    }
    public void setYear(int anyo){
        this._anyo = anyo ;
    }
    public void setMonth(int mes){
        this._mes = mes ;
    }
    public void setDay(int dia){
        this._dia = dia ;
    }
    
    //calcular el dia respecto a otra fecha
    public String calcularDiaSemana(int numDia, int mesComp, int anyoComp){
        int dia,mes,anyo,anyo1,semana,x,y,z,total,u,j;
        dia = numDia;
        mes = mesComp;
        anyo = anyoComp;
        semana = 0;
        
        if((anyo / 100)%4 == 1)
            x = semana + 5;
        else if ((anyo/100)%4==2)
            x= semana + 3;
        else if ((anyo/100)%4==3)
            x = semana + 1;
        else if ((anyo/100)%4==0)
                x = semana + 0;
        else
            x = 0;
        
        j = 0;
        z = 0;
        y = 0;
        anyo1=(anyo%100)+((anyo%100)/4);
        
        if (anyo % 400 == 0 && anyo % 100 != 0 && anyo % 4 == 0)
            if (mes==1 || mes==2)
                j=z-1;
            else
                j=z+0;

        if (mes == 8)
            u = y + 1;
        else if(mes == 2 || mes == 3 || mes == 11) 
            u = y + 2;
        else if(mes == 6) 
            u = y + 3;
        else if(mes == 9 || mes == 12 ) 
            u = y + 4;
        else if(mes == 4 || mes == 7 ) 
            u = y + 5;
        else if(mes == 1 || mes == 10 ) 
            u = y + 6;
        else 
            u = y + 0;
        
        total=x+y+z+anyo1+u+dia+j;
        if(bisiesto() && dia == 29 && mes == 2)
            total--;
        
        if (total%7==1)
            return nombresSemana[0];
        else if(total % 7 == 2)
            return nombresSemana[1];
        else if(total % 7 == 3)
            return nombresSemana[2];
        else if(total % 7 == 4)
            return nombresSemana[3];
        else if(total % 7 == 5) 
            return nombresSemana[4];
        else if(total % 7 == 6)
            return nombresSemana[5];
        else
            return nombresSemana[6];
        
    }
    
    public String calcularDiaSemana(){
        int dia,mes,anyo,anyo1,semana,x,y,z,total,u,j;
        dia = this._dia;
        mes = this._mes;
        anyo = this._anyo;
        semana = 0;
        
        if((anyo / 100)%4 == 1)
            x = semana + 5;
        else if ((anyo/100)%4==2)
            x= semana + 3;
        else if ((anyo/100)%4==3)
            x = semana + 1;
        else if ((anyo/100)%4==0)
                x = semana;
        else
            x = 0;
        
        j = 0;
        z = 0;
        y = 0;
        anyo1=(anyo%100)+((anyo%100)/4);
        
        if (anyo % 400 == 0 && anyo % 100 != 0 && anyo % 4 == 0)
            if (mes==1 || mes==2)
                j=z-1;
            else
                j=z;

        if (mes == 8)
            u = y + 1;
        else if(mes == 2 || mes == 3 || mes == 11) 
            u = y + 2;
        else if(mes == 6) 
            u = y + 3;
        else if(mes == 9 || mes == 12 ) 
            u = y + 4;
        else if(mes == 4 || mes == 7 ) 
            u = y + 5;
        else if(mes == 1 || mes == 10 ) 
            u = y + 6;
        else 
            u = y + 0;
        
        total=x+y+z+anyo1+u+dia+j;
        if(bisiesto() && dia == 29 && mes == 2)
            total--;
        
        if (total%7==1)
            return nombresSemana[0];
        else if(total % 7 == 2)
            return nombresSemana[1];
        else if(total % 7 == 3)
            return nombresSemana[2];
        else if(total % 7 == 4)
            return nombresSemana[3];
        else if(total % 7 == 5) 
            return nombresSemana[4];
        else if(total % 7 == 6)
            return nombresSemana[5];
        else
            return nombresSemana[6];
        
    }
    
    
    public boolean isSameYearIf(int anyo){
        if(this._anyo==anyo){
            return true;
        }
        return false;
    }
    public boolean isSameMonthIf(int mes){
        if(this._mes==mes){
            return true;
        }
        return false;
    }
    public boolean isSameDayIf(int dia, int mes, int anyo){
        String dia1 = calcularDiaSemana(this._dia,this._mes, this._anyo);
        String dia2 = calcularDiaSemana(dia, mes, anyo);
        if(dia1.equals(dia2)){
            return true;
        }
        return false;
    }
    public boolean isSameIf(Date fecha){
        //el dia tendria que ser el mismo dia en nombre, no numerico
        if(this._dia == fecha.getDay() && this._mes == fecha.getMonth() && this._anyo == fecha.getYear())
            return true;
        return false;
    }
    
    //comparadores sin if
    public boolean isSameYear(int anyo){
        return this._anyo==anyo;
    }
    public boolean isSameMonth(int mes){
        return this._mes==mes;
    }
    public boolean isSameDay(int dia, int mes, int anyo){
        String dia1 = calcularDiaSemana();
        String dia2 = calcularDiaSemana(dia, mes, anyo);
        return dia1.equals(dia2);

    }
    public boolean isSame(Date fecha){
        //el dia tendria que ser el mismo dia en nombre, no numerico
        return this._dia == fecha.getDay() && this._mes == fecha.getMonth() && this._anyo == fecha.getYear();
    }
    
    public String queMesEs(){
        return ""+nombreMeses[this._mes-1];
    }
    public boolean diasValidos(){
        switch (this._mes){
            case 1: //enero
                if(this._dia>32)
                    return false;
                return true;
            case 2: //febrero, se calcula si es bisiesto
                if(!bisiesto() && this._dia<29)
                    return true;
                else if(bisiesto() && this._dia<30)
                    return true;
                return false;
            case 3: //marzo
                if(this._dia>32)
                    return false;
                return true;
            case 4: //abril
                if(this._dia>31)
                    return false;
                return true;
            case 5: //mayo
                if(this._dia>32)
                    return false;
                return true;
            case 6: //junio
                if(this._dia>31)
                    return false;
                return true;
            case 7: //julio
                if(this._dia>32)
                    return false;
                return true;
            case 8: //agosto
                if(this._dia>32)
                    return false;
                return true;
            case 9: //septiembre
                if(this._dia>31)
                    return false;
                return true;
            case 10: //octubre
                if(this._dia>32)
                    return false;
                return true;
            case 11: //noviembre
                if(this._dia>31)
                    return false;
                return true;
            case 12: //diciembre
                if(this._dia>32)
                    return false;
                return true;
            default:
                return false;
        }
    }
    public void estacion(){
        String estacion = "";
        //otoño
        if(this._mes >=9 && this._mes<=12){
            if(this._dia<23 && this._mes==9)
                estacion = "Verano";
            else if(this._dia>21 && this._mes==12)
                estacion = "Invierno";
            else
                estacion = "Otoño";
        }//invierno
        if(this._mes==12 || this._mes>=1 && this._mes<=3){
            if(this._dia<21 && this._mes==12)
                estacion = "Otoño";
            else if(this._dia>21 && this._mes==4)
                estacion = "Primavera";
            else
                estacion = "Invierno";
        }//primavera
        if(this._mes>=3 && this._mes<=6){
            if(this._dia<21 && this._mes==3)
                estacion = "Invierno";
            else if(this._dia>21 && this._mes==6)
                estacion = "Verano";
            else
                estacion = "Primavera";
        }//verano
        if(this._mes >=6 && this._mes<=9){
            if(this._dia<21 && this._mes==6)
                estacion = "Primavera";
            else if(this._dia>23 && this._mes==9)
                estacion = "Otoño";
            else
                estacion = "Verano";
        }
        System.out.println(estacion);
    }
    
    private boolean bisiesto(){
        if((this._anyo % 4 == 0) && ((this._anyo % 100 != 0) || (this._anyo % 400 == 0)))
                return true;
        return false;
    }
    
    public void mesesRestantes(){
        String aux = "";
        for(int i = this._mes-1; i<12; i++){
            aux = aux + " " + nombreMeses[i];
        }
        System.out.println(aux.trim());
    }
    
    public void imprimerFechaSimple(){
        System.out.println(this._dia + "/" + this._mes + "/" + this._anyo);
    }
    public void hastaFinMes(){
        if(bisiesto()){
            for(int i = this._dia; i<=diasMesesBi[this._mes-1]; i++)
                System.out.println(i + "/" + this._mes + "/" + this._anyo);
        }else{
            for(int i = this._dia; i<=diasMesesNoBi[this._mes-1]; i++)
                System.out.println(i + "/" + this._mes + "/" + this._anyo);
        }
    }
    
    
    public void imprimerFechaExtensa(){
        String dia = calcularDiaSemana(this._dia, this._mes, this._anyo);
        System.out.println(dia + ", " + this._dia + " de " + nombreMeses[this._mes-1] + " de " + this._anyo);
    }
    
    
    public void mesesParecidos(){
        int diasMes;
        String meses = "";
        if(bisiesto()){
            diasMes = diasMesesBi[this._mes-1];
            for(int i = 0; i<12; i++){
                if(diasMes == diasMesesBi[i])
                    meses = meses + nombreMeses[i] + " ";
            }
        }else{
            diasMes = diasMesesNoBi[this._mes-1];
            for(int i = 0; i<12; i++){
                if(diasMes == diasMesesNoBi[i])
                    meses = meses + nombreMeses[i] + " ";
            }
        }
        System.out.println("Los meses con " + diasMes + " dias son: " + meses.trim());
    }
    
    public int diasPasados(){
        int dias = 0;
        for(int i = 0; i<this._mes; i++)
            dias += diasMesesNoBi[i];
        dias += this._dia;
        return dias;
    }
    
    public String fechaRandomWhile(){
        int intentos = 0;
        boolean terminado = false;
        int mesRandom, diaRandom;
        String aux = "";
        while(!terminado){
            mesRandom = (int) Math.random() * 11;
            diaRandom = (int) Math.random() * (diasMesesBi[mesRandom] - 1) + 1;
            if(this._mes == mesRandom && this._dia == diaRandom){
                terminado = true;
                aux =  diaRandom + "/" + mesRandom + "/" + this._anyo; 
            }
            intentos++;
        }
        return aux;
    }
    
    public int fechaRandomDoWhile(){
        int intentos = 0;
        boolean terminado = false;
        int mesRandom, diaRandom;
        String aux = "";
        do{
            mesRandom = (int) (Math.random() * 11);
            diaRandom = (int) (Math.random() * (diasMesesBi[mesRandom] - 1) + 1);
            //System.out.println(diaRandom + " dias / meses " + mesRandom);
            if(this._mes == mesRandom && this._dia == diaRandom){
                terminado = true;
                //aux =  diaRandom + "/" + mesRandom + "/" + this._anyo; 
            }
            intentos++;
        }while(!terminado);
        return intentos;
    }
}
