
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;
import java.util.StringTokenizer;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author adesudiman
 */
public class BattleShip {
    
    public int[][] generateMapAI(){
        
        int[][] mapAI = new int[10][10];
        Random rn = new Random();
        int ukuranKapal;
        for (int ii = 0; ii < 10; ++ii) {
            int row, col;
            if (ii > 5) {
                ukuranKapal = 1;
            } else if (ii > 2) {
                ukuranKapal = 2;
            } else if (ii > 0) {
                ukuranKapal = 3;
            } else {
                ukuranKapal = 4;
            }
            
            boolean available;
            do {
                do {
                    row = rn.nextInt(10);
                    col = rn.nextInt(10);
                } while (mapAI[row][col] != 0);
                available = true;
                int arahKapal = rn.nextInt(2);
                //System.out.println(ukuranKapal);
                //cek available atau tidak


                //horizontal
                if (arahKapal == 0) {
                    for (int mm = 0; mm < ukuranKapal; ++mm) {
                        if (col + mm >= 10) {
                            available = false;
                        } else {
                            if (mapAI[row][col + mm] == 1 || mapAI[row][col + mm] == 2) {
                                available = false;
                            }
                        }
                    }
                    //coba ganti arah ke vertikal
                    if (!available) {
                        available = true;
                        for (int mm = 0; mm < ukuranKapal; ++mm) {
                            if (row + mm >= 10) {
                                available = false;
                            } else if (mapAI[row + mm][col] == 1 || mapAI[row + mm][col] == 2) {
                                available = false;
                            }
                        }

                        if (available) {
                            //vertikal
                            for (int mm = 0; mm < ukuranKapal; ++mm) {
                                mapAI[row + mm][col] = 1;
                                if (col - 1 >= 0) {
                                    mapAI[row + mm][col - 1] = 2;
                                }
                                if (col + 1 < 10) {
                                    mapAI[row + mm][col + 1] = 2;
                                }
                            }
                            if (row - 1 >= 0) {
                                mapAI[row - 1][col] = 2;
                                if (col - 1 >= 0) {
                                    mapAI[row - 1][col - 1] = 2;
                                }
                                if (col + 1 < 10) {
                                    mapAI[row - 1][col + 1] = 2;
                                }
                            }

                            if (row + ukuranKapal < 10) {
                                mapAI[row + ukuranKapal][col] = 2;
                                if (col - 1 >= 0) {
                                    mapAI[row + ukuranKapal][col - 1] = 2;
                                }
                                if (col + 1 < 10) {
                                    mapAI[row + ukuranKapal][col + 1] = 2;
                                }
                            }
                        }

                    } else {
                        //horizontal
                        for (int mm = 0; mm < ukuranKapal; ++mm) {
                            mapAI[row][col + mm] = 1;
                            if (row - 1 >= 0) {
                                mapAI[row - 1][col + mm] = 2;
                            }
                            if (row + 1 < 10) {
                                mapAI[row + 1][col + mm] = 2;
                            }
                        }
                        if (col - 1 >= 0) {
                            mapAI[row][col - 1] = 2;
                            if (row - 1 >= 0) {
                                mapAI[row - 1][col - 1] = 2;
                            }
                            if (row + 1 < 10) {
                                mapAI[row + 1][col - 1] = 2;
                            }
                        }
                        if (col + ukuranKapal < 10) {
                            mapAI[row][col + ukuranKapal] = 2;
                            if (row - 1 >= 0) {
                                mapAI[row - 1][col + ukuranKapal] = 2;
                            }
                            if (row + 1 < 10) {
                                mapAI[row + 1][col + ukuranKapal] = 2;
                            }
                        }
                    }

                    //vertikal
                } else {
                    for (int mm = 0; mm < ukuranKapal; ++mm) {
                        if (row + mm >= 10) {
                            available = false;
                        } else if (mapAI[row + mm][col] == 1 || mapAI[row + mm][col] == 2) {
                            available = false;
                        }
                    }
                    //coba ganti arah ke horizontal
                    if (!available) {
                        available = true;
                        for (int mm = 0; mm < ukuranKapal; ++mm) {
                            if (col + mm >= 10) {
                                available = false;
                            } else if (mapAI[row][col + mm] == 1 || mapAI[row][col + mm] == 2) {
                                available = false;
                            }
                        }

                        //horizontal
                        if (available) {
                            for (int mm = 0; mm < ukuranKapal; ++mm) {
                                mapAI[row][col + mm] = 1;
                                if (row - 1 >= 0) {
                                    mapAI[row - 1][col + mm] = 2;
                                }
                                if (row + 1 < 10) {
                                    mapAI[row + 1][col + mm] = 2;
                                }
                            }
                            if (col - 1 >= 0) {
                                mapAI[row][col - 1] = 2;
                                if (row - 1 >= 0) {
                                    mapAI[row - 1][col - 1] = 2;
                                }
                                if (row + 1 < 10) {
                                    mapAI[row + 1][col - 1] = 2;
                                }
                            }
                            if (col + ukuranKapal < 10) {
                                mapAI[row][col + ukuranKapal] = 2;
                                if (row - 1 >= 0) {
                                    mapAI[row - 1][col + ukuranKapal] = 2;
                                }
                                if (row + 1 < 10) {
                                    mapAI[row + 1][col + ukuranKapal] = 2;
                                }
                            }
                        }
                        //vertikal
                    } else {
                        for (int mm = 0; mm < ukuranKapal; ++mm) {
                            mapAI[row + mm][col] = 1;
                            if (col - 1 >= 0) {
                                mapAI[row + mm][col - 1] = 2;
                            }
                            if (col + 1 < 10) {
                                mapAI[row + mm][col + 1] = 2;
                            }
                        }
                        if (row - 1 >= 0) {
                            mapAI[row - 1][col] = 2;
                            if (col - 1 >= 0) {
                                mapAI[row - 1][col - 1] = 2;
                            }
                            if (col + 1 < 10) {
                                mapAI[row - 1][col + 1] = 2;
                            }
                        }

                        if (row + ukuranKapal < 10) {
                            mapAI[row + ukuranKapal][col] = 2;
                            if (col - 1 >= 0) {
                                mapAI[row + ukuranKapal][col - 1] = 2;
                            }
                            if (col + 1 < 10) {
                                mapAI[row + ukuranKapal][col + 1] = 2;
                            }
                        }
                    }
                }
            } while (!available);
        }
        return mapAI;
    }

    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.US);
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        BattleShip game = new BattleShip();

        System.out.println("ini adalah Game battle ship");
        System.out.println("Penjelasan game battle ship");
        System.out.println("Terdapat board ukuran 10 x 10");
        System.out.println("Baris 1-10 dan Kolom 1-10");
        System.out.println("Terdapat 4 type sesuai ukuran kapal dari 1-4 kotak");
        System.out.println("Setiap Pemain harus menempatkan 1 kapal ukuran 1x4 kotak, 2 kapal ukuran kapal ukuran 1x3 kotak, 3 kapal ukuran 1 x2 kotak dan 4 kapal ukuran kapal 1x1 kotak dalam board dimana saja yang player inginkan");
        System.out.println("Cara menempatkan kapal(hanya boleh vertikan atau horizontal) bila kapal ditempatkan pada suatu kotak maka kapal lain tidak boleh ditempatkan sangat berdekatan dengan kapal tersebut , minimal jarak adalah 1 kotak");
        System.out.println("Contoh misalkan anda menempatkan kapal ukuran 1x4 secara horizontal di b2-b5 maka anda tidak boleh menempatkan kapal di daerah a1-c1,a2-a5, c2-c5, a6-c6");
        System.out.println("Kemudian pemain secara bergantian mulai menebak dimana letak kapal musul, yang berhasil menghancurkan semua kapal musuh terlebih dahulu dialah yang menang");
        System.out.println("Bila anda hit dalam giliran tersebut anda akan berhak untuk menebak kembali kapal musuh , bila miss anda akan ganti giliran");
        System.out.println("Di program ini akan disimulasikan generator map dan agen AI yang akan menebak atau menyelesaikan map kapal tersebut");
        System.out.println("Map yang akan di selesaikan AI");
        System.out.println("Ket: x adalah bila ai menembak dan hit, o bila ai menembak dan misss, z adalah ai menandakan daerah tersebut tidak perlu dibuka");
        System.out.println("Algoritma yang digunakan untuk generator map adalah randomized + csp");
        System.out.println("Algoritma yang digunakan untuk solver randomized with priority and probability, serta state space ketika hit dan miss");
        System.out.println("Saya bersedia bila diminta/dipanggil menjelaskan algoritma yang digunakan dalam program ini");
        /* int[][] mapPlayer = new int[10][10];
         for(int ii = 0; ii < 10; ++ii){
         StringTokenizer tk = new StringTokenizer(br.readLine());
         for(int jj =0 ; jj < 10; ++jj){
         if(tk.nextToken().equals("x")){
         mapPlayer[ii][jj] = 1;
         }
         }
         }*/

        int [][] mapAi = game.generateMapAI();
        System.out.println();
        game.cetakMap(mapAi);
        int[][] mapTebakan = new int[10][10];
        int maxHit = 20;
        ArrayList<Kordinat> tebakan = new ArrayList<Kordinat>();
        System.out.println();
        maxHit = 20;
        while(maxHit > 0){
            if(game.jalanAI(mapTebakan, tebakan, mapAi))maxHit--;    
            game.cetakMap(mapTebakan);
            System.out.println();
        }        
        System.out.println("copyright Ade Sudiman 2013");
    }

    public void cetakMap(int[][] x) {
        for (int ii = 0; ii < x.length; ++ii) {
            for (int jj = 0; jj < x[ii].length; ++jj) {
                if (x[ii][jj] == 1) {
                    System.out.print("x");
                } else if(x[ii][jj] == 2){
                    System.out.print("o");
                }else if(x[ii][jj] == 3){
                    System.out.print("z");
                }else{
                    System.out.print("-");
                }
                if (jj != x[ii].length - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public boolean jalanAI(int[][] mapTebakan, ArrayList<Kordinat> kemungkinan, int[][] mapMusuh) {
        boolean hit = false;
        //2 bila sudah dibuka tapi miss, 1 bila hit
        if (!kemungkinan.isEmpty()) {
            Kordinat tbkn = randomKemungkinan(kemungkinan);
            int row = tbkn.x;
            int col = tbkn.y;
            removeKordinat(kemungkinan, row, col);
            System.out.println("Menembak di ("+(row+1)+","+(col+1)+")");
            //hit at kordinat row col
            if (mapMusuh[row][col] == 1) {
                mapTebakan[row][col] = 1;
                hit = true;
                boolean atas = true, bawah = true, kiri= true, kanan = true, ketemu = false;
                //cek hit 1 tetangga atas
                //System.out.println("Baris "+ row + "Kolom  "+ col );
                if (row - 1 >= 0 && mapTebakan[row - 1][col] == 1) {
                    if (col + 1 < 10) {
                        removeKordinat(kemungkinan, row - 1, col + 1);
                    }
                    if (col - 1 >= 0) {
                        removeKordinat(kemungkinan, row - 1, col - 1);
                    }
                    //cek hit 2 tetangga atas
                    if (row - 2 >= 0) {
                        if (mapTebakan[row - 2][col] == 0) {
                            
                            bawah = true;
                            atas = false;
                            kiri = false;
                            kanan = false;
                        } else if (mapTebakan[row - 2][col] == 2) {
                            bawah = true;
                            atas = false;
                            kiri = false;
                            kanan = false;

                            
                            if (row + 1 >= 10 || mapTebakan[row+1][col] == 2 || mapTebakan[row+1][col] ==3) {
                                if (col - 1 >= 0) {
                                    if(row+1 < 10 && mapTebakan[row+1][col-1] !=2)mapTebakan[row+1][col-1]=3;
                                    if(mapTebakan[row][col-1] !=2)mapTebakan[row][col-1] =3;
                                    if(mapTebakan[row-1][col-1] != 2)mapTebakan[row-1][col-1] =3;
                                    if(mapTebakan[row-2][col-1] != 2)mapTebakan[row-2][col-1] =3;
                                }
                                if (col + 1 < 10) {
                                    if(row+1 < 10 && mapTebakan[row+1][col+1] !=2)mapTebakan[row+1][col+1]=3;
                                    if(mapTebakan[row][col+1] !=2)mapTebakan[row][col+1] =3;
                                    if(mapTebakan[row-1][col+1] != 2)mapTebakan[row-1][col+1] =3;
                                    if(mapTebakan[row-2][col+1] != 2)mapTebakan[row-2][col+1] =3;
                                }
                            }
                        } else {
                            if (row - 3 >= 0) {
                                if (mapTebakan[row - 3][col] == 1) {
                                    if (col - 1 >= 0) {
                                        for (int rr = 0; rr < 4; ++rr) {
                                            if (mapTebakan[row - 3 + rr][col - 1] != 2) {
                                                mapTebakan[row - 3 + rr][col - 1] = 3;
                                            }
                                        }
                                        if (row - 4 >= 0 && mapTebakan[row - 4][col - 1] != 2) {
                                            mapTebakan[row - 4][col - 1] = 3;
                                        }
                                        if (row + 1 < 10 && mapTebakan[row + 1][col - 1] != 2) {
                                            mapTebakan[row + 1][col - 1] = 3;
                                        }
                                    }
                                    if (col + 1 < 10 ) {
                                        for (int rr = 0; rr < 4; ++rr) {
                                            if (mapTebakan[row - 3 + rr][col + 1] != 2) {
                                                mapTebakan[row - 3 + rr][col + 1] = 3;
                                            }
                                        }
                                        if (row - 4 >= 0 && mapTebakan[row - 4][col + 1] != 2) {
                                            mapTebakan[row - 4][col + 1] = 3;
                                        }
                                        if (row + 1 < 10 && mapTebakan[row + 1][col + 1] != 2) {
                                            mapTebakan[row + 1][col + 1] = 3;
                                        }
                                    }
                                    if (row - 4 >= 0 && mapTebakan[row - 4][col] != 2) {
                                        mapTebakan[row - 4][col] = 3;
                                    }
                                    if (row + 1 < 10 && mapTebakan[row + 1][col] != 2) {
                                        mapTebakan[row + 1][col] = 3;
                                    }
                                    bawah = false;
                                    atas = false;
                                    kiri = false;
                                    kanan = false;
                                } else if (mapTebakan[row-3][col] ==2){
                                    if (row + 1 >= 10 || mapTebakan[row+1][col] == 2 || mapTebakan[row+1][col] ==3) {
                                        if (col - 1 >= 0) {
                                            if(row+1 < 10 && mapTebakan[row+1][col-1] != 2)mapTebakan[row+1][col-1] = 3;
                                            if(mapTebakan[row][col-1] != 2)mapTebakan[row][col-1] =3;
                                            if(mapTebakan[row-1][col-1] != 2)mapTebakan[row-1][col-1] =3;
                                            if(mapTebakan[row-2][col-1] != 2)mapTebakan[row-2][col-1] =3;
                                            if(mapTebakan[row-3][col-1] != 2)mapTebakan[row-3][col-1] =3;                                            
                                        }
                                        if (col + 1 < 10) {
                                            if(row+1 < 10 && mapTebakan[row+1][col+1] != 2)mapTebakan[row+1][col+1] = 3;
                                            if(mapTebakan[row][col+1] != 2)mapTebakan[row][col+1] =3;
                                            if(mapTebakan[row-1][col+1] != 2)mapTebakan[row-1][col+1] =3;
                                            if(mapTebakan[row-2][col+1] != 2)mapTebakan[row-2][col+1] =3;
                                            if(mapTebakan[row-3][col+1] != 2)mapTebakan[row-3][col+1] =3;                                            
                                        }
                                    }
                                    bawah = true;
                                    kanan = false;
                                    atas = false;
                                    kiri = false;
                                }else {
                                    bawah = true;
                                    atas = false;
                                    kiri = false;
                                    kanan = false;
                                }
                            }else{
                                 if (mapTebakan[row+1][col] == 2 || mapTebakan[row+1][col] ==3) {
                                        if (col-1 >= 0) {
                                            for (int tt = 0; tt < 4; ++tt) {
                                                if (mapTebakan[row - 2 + tt][col - 1] != 2) {
                                                    mapTebakan[row - 2 + tt][col - 1] = 3;
                                                }
                                            }
                                        }
                                        if (col + 1 < 10) {
                                            for (int tt = 0; tt < 4; ++tt) {
                                                if (mapTebakan[row - 2 + tt][col + 1] != 2) {
                                                    mapTebakan[row - 2 + tt][col + 1] = 3;
                                                }
                                            }
                                        }
                                        
                                    }                                
                                bawah = true;
                                atas = false;
                                kiri = false;
                                kanan = false;
                            }
                        }
                    } else {
                        
                        if (mapTebakan[row+1][col] == 2 || mapTebakan[row+1][col] ==3) {
                            if (col - 1 >= 0) {
                                for (int tt = 0; tt < 3; ++tt) {
                                    if (mapTebakan[row - 1 + tt][col - 1] != 2) {
                                        mapTebakan[row - 1 + tt][col - 1] = 3;
                                    }
                                }
                            }
                            if (col + 1 < 10) {
                                for (int tt = 0; tt < 3; ++tt) {
                                    if (mapTebakan[row - 1 + tt][col + 1] != 2) {
                                        mapTebakan[row - 1 + tt][col + 1] = 3;
                                    }
                                }
                            }
                        }                            
                        bawah = true;
                        atas = false;
                        kiri = false;
                        kanan = false;
                    }
                    ketemu = true; 
                }
                //cek hit tetangga bawah
                if(!ketemu && row + 1 < 10 && mapTebakan[row + 1][col] == 1) {
                        if (col + 1 < 10) {
                            removeKordinat(kemungkinan, row + 1, col + 1);
                        }
                        if (col - 1 >= 0) {
                            removeKordinat(kemungkinan, row + 1, col - 1);
                        }
                        //cek hit 2 tetangga bawah
                        if (row + 2 < 10) {
                            if (mapTebakan[row + 2][col] == 0) {
                                atas = true; bawah= false; kiri = false; kanan = false;
                            }else if(mapTebakan[row+2][col]== 2){
                                atas = true; bawah= false; kiri = false; kanan = false;
                                if(row-1 <0 || mapTebakan[row-1][col] ==2 || mapTebakan[row-1][col] ==3){
                                    if(col-1>=0){
                                        if(row-1 >=0 && mapTebakan[row-1][col-1] != 2)mapTebakan[row-1][col-1] =3;
                                        if(mapTebakan[row][col-1]!= 2) mapTebakan[row][col-1]=3;
                                        if(mapTebakan[row+1][col-1]!= 2) mapTebakan[row+1][col-1]=3;
                                        if(mapTebakan[row+2][col-1]!= 2) mapTebakan[row+2][col-1]=3;
                                    }
                                    if(col+1<10){
                                        if(row-1 >=0 && mapTebakan[row-1][col+1] != 2)mapTebakan[row-1][col+1] =3;
                                        if(mapTebakan[row][col+1]!= 2) mapTebakan[row][col+1]=3;
                                        if(mapTebakan[row+1][col+1]!= 2) mapTebakan[row+1][col+1]=3;
                                        if(mapTebakan[row+2][col+1]!= 2) mapTebakan[row+2][col+1]=3;
                                    }
                                }
                            }else {
                                if(row+3 <10){
                                    if(mapTebakan[row+3][col] == 1){
                                        if(col-1>=0){
                                            for(int ww=0; ww <4; ++ww){
                                                if(mapTebakan[row+ww][col-1]!=2)mapTebakan[row+ww][col-1] =3;
                                            }
                                            if(row-1>=0 && mapTebakan[row-1][col-1] != 2)mapTebakan[row-1][col-1] =3;
                                            if(row+4 <10 && mapTebakan[row+4][col-1]!=2)mapTebakan[row+4][col-1] =3;
                                        }
                                        if(col+1 <10){
                                            for(int ww=0; ww <4; ++ww){
                                                if(mapTebakan[row+ww][col+1]!=2)mapTebakan[row+ww][col+1] =3;
                                            }
                                            if(row-1>=0 && mapTebakan[row-1][col+1] != 2)mapTebakan[row-1][col+1] =3;
                                            if(row+4 <10 && mapTebakan[row+4][col+1]!=2)mapTebakan[row+4][col+1] =3;                                            
                                        }
                                        if(row-1>=0 && mapTebakan[row-1][col] !=2) mapTebakan[row-1][col] = 3;
                                        if(row+4<10 && mapTebakan[row+4][col] !=2) mapTebakan[row+4][col] = 3;
                                        bawah = false;
                                        atas = false;
                                        kiri = false;
                                        kanan = false;
                                        
                                    }else if(mapTebakan[row+3][col]==2){
                                        if(row-1<0 || mapTebakan[row-1][col] ==2 || mapTebakan[row-1][col] ==3){
                                            if(col-1>=0){
                                                if(row-1 >=0 && mapTebakan[row-1][col-1] != 2)mapTebakan[row-1][col-1] =3;
                                                if(mapTebakan[row][col-1]!= 2) mapTebakan[row][col-1]=3;
                                                if(mapTebakan[row+1][col-1]!= 2) mapTebakan[row+1][col-1]=3;
                                                if(mapTebakan[row+2][col-1]!= 2) mapTebakan[row+2][col-1]=3;
                                                if(mapTebakan[row+3][col-1]!= 2) mapTebakan[row+3][col-1]=3;                                       
                                            }
                                            if(col+1<10){
                                                if(row-1 >=0 && mapTebakan[row-1][col+1] != 2)mapTebakan[row-1][col+1] =3;
                                                if(mapTebakan[row][col+1]!= 2) mapTebakan[row][col+1]=3;
                                                if(mapTebakan[row+1][col+1]!= 2) mapTebakan[row+1][col+1]=3;
                                                if(mapTebakan[row+2][col+1]!= 2) mapTebakan[row+2][col+1]=3;
                                                if(mapTebakan[row+3][col+1]!= 2) mapTebakan[row+3][col+1]=3;
                                            }
                                            
                                        }   
                                        bawah = false;
                                        atas = true;
                                        kiri = false;
                                        kanan = false;
                                        
                                    }else {
                                        bawah = false;
                                        atas = true;
                                        kiri = false;
                                        kanan = false;
                                    }
                                }else {
                                        if(mapTebakan[row-1][col] ==2 || mapTebakan[row-1][col] ==3){
                                            if(col-1>=0){
                                                for(int ww =0; ww<4; ++ww ){
                                                    if(mapTebakan[row-1+ww][col-1]!= 2)mapTebakan[row-1+ww][col-1] =3;
                                                }
                                            }
                                            if(col+1<10){
                                                for(int ww=0; ww <4 ; ++ww){
                                                    if(mapTebakan[row-1+ww][col+1]!= 2)mapTebakan[row-1+ww][col+1]=3;
                                                }
                                            }
                                            
                                        }   
                                    
                                    bawah = false;
                                    atas = true;
                                    kiri = false;
                                    kanan = false;
                                }
                            }
                        }else {
                                if(mapTebakan[row-1][col] ==2 || mapTebakan[row-1][col] ==3){
                                    if(col-1>=0){
                                        for(int ww = 0; ww < 3; ++ww){
                                            if(mapTebakan[row-1+ww][col-1]!= 2)mapTebakan[row-1+ww][col-1] =3;
                                        }
                                    }
                                    if(col+1<10){
                                        for(int ww = 0; ww <3; ++ww){
                                            if(mapTebakan[row-1+ww][col+1]!= 2)mapTebakan[row-1+ww][col+1] = 3;
                                        }
                                    }
                                }                                
                            bawah = false;
                            atas = true;
                            kiri = false;
                            kanan = false;

                        }
                        ketemu = true; 
                    
                } 
                //cek tetanga kiri
                if (!ketemu && col - 1 >= 0 && mapTebakan[row][col - 1] == 1) {
 
                    if (row + 1 < 10) {
                        removeKordinat(kemungkinan, row - 1, col - 1);
                    }
                    if (row - 1 >= 0) {
                        removeKordinat(kemungkinan, row + 1, col - 1);
                    }
                    //cek hit 2 tetangga kiri
                        if (col - 2 >= 0) {
                            if (mapTebakan[row][col - 2] == 0) {
                                                        
                                kanan = true; kiri = false; bawah = false; atas = false;
                            }else if(mapTebakan[row][col-2] == 2) {
                                                        
                                kanan = true; 
                                kiri = false; 
                                bawah = false; 
                                atas = false;
                                
                                if(col+1 >=10 || mapTebakan[row][col+1] == 2 || mapTebakan[row][col+1] ==3){
                                    if(row-1 >=0){
                                        if(col+1 < 10 && mapTebakan[row-1][col+1] != 2)mapTebakan[row-1][col+1] =3;
                                        if(mapTebakan[row-1][col] != 2)mapTebakan[row-1][col] = 3;
                                        if(mapTebakan[row-1][col-1] != 2)mapTebakan[row-1][col-1] =3;
                                        if(mapTebakan[row-1][col-2] != 2)mapTebakan[row-1][col-2] = 3;
                                        
                                    }
                                    if(row+1 < 10){
                                        if(col+1 < 10 && mapTebakan[row+1][col+1] != 2)mapTebakan[row+1][col+1] =3;
                                        if(mapTebakan[row+1][col] != 2)mapTebakan[row+1][col] = 3;
                                        if(mapTebakan[row+1][col-1] != 2)mapTebakan[row+1][col-1] =3;
                                        if(mapTebakan[row+1][col-2] != 2)mapTebakan[row+1][col-2] = 3;
                                        
                                    }
                                }
                            }else {
                                if(col-3>=0){
                                    if(mapTebakan[row][col-3] == 1){
                                        if(row-1 >=0){
                                            for(int ww =0 ;ww <4; ++ww){
                                               if(mapTebakan[row-1][col-3+ww] != 2)mapTebakan[row-1][col-3+ww] =3; 
                                            }
                                            if(col-4 >=0 && mapTebakan[row-1][col-4]!=2)mapTebakan[row-1][col-4] =3;
                                            if(col+1 < 10 && mapTebakan[row-1][col+1] !=2)mapTebakan[row-1][col+1] =3;
                                        }
                                        if(row+1 <10){
                                            for(int ww =0 ;ww <4; ++ww){
                                               if(mapTebakan[row+1][col-3+ww] != 2)mapTebakan[row+1][col-3+ww] =3; 
                                            }
                                            if(col-4 >=0 && mapTebakan[row+1][col-4]!=2)mapTebakan[row+1][col-4] =3;
                                            if(col+1 < 10 && mapTebakan[row+1][col+1] !=2)mapTebakan[row+1][col+1] =3;
                                        }
                                        if(col-4>=0 && mapTebakan[row][col-4] != 2) mapTebakan[row][col-4]= 3;
                                        if(col+1<10 && mapTebakan[row][col+1] != 2) mapTebakan[row][col+1]= 3;
                                        bawah = false;
                                        atas = false;
                                        kiri = false;
                                        kanan = false;
                                    }else if (mapTebakan[row][col-3] ==2){
                                        if(col+1>=10 || mapTebakan[row][col+1] == 2 || mapTebakan[row][col+1] == 3){
                                            if(row-1 >=0){
                                                if(col+1 < 10 && mapTebakan[row-1][col+1] != 2)mapTebakan[row-1][col+1] =3;
                                                if(mapTebakan[row-1][col] != 2)mapTebakan[row-1][col] = 3;
                                                if(mapTebakan[row-1][col-1] != 2)mapTebakan[row-1][col-1] =3;
                                                if(mapTebakan[row-1][col-2] != 2)mapTebakan[row-1][col-2] = 3;
                                                if(mapTebakan[row-1][col-3] != 2)mapTebakan[row-1][col-3] =3;
                                            }
                                            if(row+1 <10){
                                                if(col+1 < 10 && mapTebakan[row+1][col+1] != 2)mapTebakan[row+1][col+1] =3;
                                                if(mapTebakan[row+1][col] != 2)mapTebakan[row+1][col] = 3;
                                                if(mapTebakan[row+1][col-1] != 2)mapTebakan[row+1][col-1] =3;
                                                if(mapTebakan[row+1][col-2] != 2)mapTebakan[row+1][col-2] = 3;
                                                if(mapTebakan[row+1][col-3] != 2)mapTebakan[row+1][col-3] =3;
                                            }
                                        }
                                            bawah = false;
                                            atas = false;
                                            kanan = true;
                                            kiri = false;
                                        
                                        
                                    }else {
                                        bawah = false;
                                        atas = false;
                                        kiri = false;
                                        kanan = true;
                                    }  
                                }else {
                                        if(mapTebakan[row][col+1] == 2 || mapTebakan[row][col+1] == 3){
                                            if(row-1 >=0){
                                                for(int ww =0; ww < 4 ; ++ww){
                                                    if(mapTebakan[row-1][col-2+ww] != 2)mapTebakan[row-1][col-2+ww] = 3;
                                                }
                                            }
                                            if(row+1 <10){
                                                for(int ww =0; ww < 4 ; ++ww){
                                                    if(mapTebakan[row+1][col-2+ww] != 2)mapTebakan[row+1][col-2+ww] = 3;
                                                }
                                            }
                                        }
                                    
                                    bawah = false;
                                    atas = false;
                                    kiri = false;
                                    kanan = true;
                                }
                                
                            }
                        }else {
                            
                                if(mapTebakan[row][col+1] == 2 || mapTebakan[row][col+1] ==3){
                                    if(row-1 >=0){
                                        for(int ww =0 ; ww <3; ++ww){
                                            if(mapTebakan[row-1][col-1+ww]!=2)mapTebakan[row-1][col-1+ww] =3;
                                        }
                                    }
                                    if(row+1 < 10){
                                        for(int ww =0 ; ww <3; ++ww){
                                            if(mapTebakan[row+1][col-1+ww]!=2)mapTebakan[row+1][col-1+ww] =3;
                                        }
                                    }
                                }

                            bawah = false;
                            atas = false;
                            kiri = false;
                            kanan = true;
                        }
                        //System.out.println("ketemu tetangga di kiri");
                        
                        ketemu = true;   
                    
                }
                //cek tetangga kanan
                if (!ketemu&& col + 1 < 10 && mapTebakan[row][col + 1] == 1) {
                    if (row + 1 < 10) {
                            removeKordinat(kemungkinan, row - 1, col + 1);
                        }
                    if (row - 1 >= 0) {
                        removeKordinat(kemungkinan, row + 1, col + 1);
                    }
                        //cek hit 2 tetangga kanan
                        if (col + 2 < 10) {
                            if (mapTebakan[row][col+2] == 0) {
                                kiri = true;
                                kanan = false;
                                atas = false;
                                bawah = false;
                            }else if(mapTebakan[row][col+2] == 2){
                                kiri = true;
                                kanan = false;
                                atas = false;
                                bawah = false;
                                if(col-1<0 || mapTebakan[row][col-1] ==2 || mapTebakan[row][col-1] == 3){
                                    if(row-1>=0){
                                        if(col-1 >=0 && mapTebakan[row-1][col-1] != 2)mapTebakan[row-1][col-1] =3;
                                        if(mapTebakan[row-1][col] != 2)mapTebakan[row-1][col] = 3;
                                        if(mapTebakan[row-1][col+1] != 2)mapTebakan[row-1][col+1] = 3;
                                        if(mapTebakan[row-1][col+2] != 2)mapTebakan[row-1][col+2] = 3;
                                    }
                                    if(row+1 < 10){
                                        if(col-1 >=0 && mapTebakan[row+1][col-1] != 2)mapTebakan[row+1][col-1] =3;
                                        if(mapTebakan[row+1][col] != 2)mapTebakan[row+1][col] = 3;
                                        if(mapTebakan[row+1][col+1] != 2)mapTebakan[row+1][col+1] = 3;
                                        if(mapTebakan[row+1][col+2] != 2)mapTebakan[row+1][col+2] = 3;
                                    }
                                }
                                
                            }else {
                                if(col+3 < 10){
                                    if(mapTebakan[row][col+3] == 1){
                                        if(row-1 >=0){
                                            for(int ww =0 ;ww <4; ++ww){
                                               if(mapTebakan[row-1][col+ww] != 2)mapTebakan[row-1][col] =3; 
                                            }
                                            if(col-1 >=0 && mapTebakan[row-1][col-1]!=2)mapTebakan[row-1][col-1] =3;
                                            if(col+4 < 10 && mapTebakan[row-1][col+4] !=2)mapTebakan[row-1][col+4] =3;
                                        }
                                        if(row+1 <10){
                                            for(int ww =0 ;ww <4; ++ww){
                                               if(mapTebakan[row+1][col] != 2)mapTebakan[row+1][col] =3; 
                                            }
                                            if(col-1 >=0 && mapTebakan[row+1][col-1]!=2)mapTebakan[row+1][col-1] =3;
                                            if(col+4 < 10 && mapTebakan[row+1][col+4] !=2)mapTebakan[row+1][col+4] =3;
                                        }
                                        if(col-1>=0 && mapTebakan[row][col-1] != 2) mapTebakan[row][col-1]= 3;
                                        if(col+4<10 && mapTebakan[row][col+4] != 2) mapTebakan[row][col+4]= 3;
                                        bawah = false;
                                        atas = false;
                                        kiri = false;
                                        kanan = false;
                                    }else if (mapTebakan[row][col+3] ==2){
                                        if(col-1< 0 || mapTebakan[row][col-1] ==2 || mapTebakan[row][col-1] ==3){
                                            if(row-1 >=0){
                                                if(col-1 >=0 && mapTebakan[row-1][col-1] != 2)mapTebakan[row-1][col-1] =3;
                                                if(mapTebakan[row-1][col] != 2)mapTebakan[row-1][col] = 3;
                                                if(mapTebakan[row-1][col+1] != 2)mapTebakan[row-1][col+1] = 3;
                                                if(mapTebakan[row-1][col+2] != 2)mapTebakan[row-1][col+2] = 3;
                                                if(mapTebakan[row-1][col+3] != 2)mapTebakan[row-1][col+3] = 3;
                                            }
                                            if(row+1 <10){
                                                if(col-1 >=0 && mapTebakan[row+1][col-1] != 2)mapTebakan[row+1][col-1] =3;
                                                if(mapTebakan[row+1][col] != 2)mapTebakan[row+1][col] = 3;
                                                if(mapTebakan[row+1][col+1] != 2)mapTebakan[row+1][col+1] = 3;
                                                if(mapTebakan[row+1][col+2] != 2)mapTebakan[row+1][col+2] = 3;
                                                if(mapTebakan[row+1][col+3] != 2)mapTebakan[row+1][col+3] = 3;
                                            }
                                        }
                                            bawah = false;
                                            atas = false;
                                            kanan = false;
                                            kiri = true;
                                        
                                        
                                    }else {
                                        bawah = false;
                                        atas = false;
                                        kiri = true;
                                        kanan = false;
                                    }  
                                }else {
                                        if(mapTebakan[row][col-1] ==2 || mapTebakan[row][col-1] ==3){
                                            if(row-1 >=0){
                                                for(int ww =0; ww < 4 ; ++ww){
                                                    if(mapTebakan[row-1][col-1+ww] != 2)mapTebakan[row-1][col-1+ww] = 3;
                                                }
                                            }
                                            if(row+1 <10){
                                                for(int ww =0; ww < 4 ; ++ww){
                                                    if(mapTebakan[row+1][col-1+ww] != 2)mapTebakan[row+1][col-1+ww] = 3;
                                                }
                                            }
                                        }

                                    bawah = false;
                                    atas = false;
                                    kiri = true;
                                    kanan = false;
                                }
                                
                            }
                        }else {
                                if( mapTebakan[row][col-1] ==2 || mapTebakan[row][col-1] == 3){
                                    if(row-1>=0){
                                        for(int ww = 0; ww <3 ; ++ww){
                                            if(mapTebakan[row-1][col-1+ww] != 2)mapTebakan[row-1][col-1+ww] = 3;
                                        }
                                    }
                                    if(row+1 < 10){
                                        for(int ww = 0; ww <3 ; ++ww){
                                            if(mapTebakan[row+1][col-1+ww] != 2)mapTebakan[row+1][col-1+ww] = 3;
                                        }
                                    }
                                }

                            kanan = false;
                            atas = false;
                            bawah = false;
                            kiri = true;
                        }
                        //case 1 tetangga kanan hit      
                        //update kemungkinan
                        //System.out.println("ketemu tetangga di kanan");
                        //case tidak ada tetangga atas hit
                        ketemu = true;
                    
                }
                //System.out.println(atas +" " + bawah + " "+ kiri+ " " + kanan);
                if(!ketemu && (row-1 <0 || mapTebakan[row-1][col] == 2 || mapTebakan[row-1][col] == 3) && (row+1 >= 10 || mapTebakan[row+1][col] ==2 || mapTebakan[row+1][col] == 3) && (col-1<0 || mapTebakan[row][col-1] == 2 || mapTebakan[row][col-1] == 3) && (col+1 >= 10 || mapTebakan[row][col+1] ==2 || mapTebakan[row][col+1] ==3)){
                    if(col-1 >=0){
                        if(row-1>=0 && mapTebakan[row-1][col-1] != 2)mapTebakan[row-1][col-1] =3;
                        if(row+1 <10 && mapTebakan[row-1][col-1]!= 2 )mapTebakan[row+1][col-1] =3;
                    }
                    if(col+1 < 10){
                        if(row-1 >=0 && mapTebakan[row-1][col+1] != 2)mapTebakan[row-1][col+1] =3;
                        if(row+1 < 10 && mapTebakan[row+1][col+1] != 2)mapTebakan[row+1][col+1] =3;
                    }
                }
                if(!ketemu){   
                    //System.out.println("alay");
                    if(atas && row-1 >=0 && mapTebakan[row-1][col] == 0)kemungkinan.add(new Kordinat(row-1,col,1));
                    if(bawah && row+1 < 10 && mapTebakan[row+1][col] == 0) kemungkinan.add(new Kordinat(row+1, col,1));
                    if(kiri && col-1 >=0 && mapTebakan[row][col-1] == 0)kemungkinan.add(new Kordinat(row, col-1,1));
                    if(kanan && col+1 < 10 && mapTebakan[row][col+1] == 0) kemungkinan.add(new Kordinat(row, col+1,1));
                }else {
                    //System.out.println("WOY ");
                    if(atas && row-1 >=0 && mapTebakan[row-1][col] == 0)kemungkinan.add(new Kordinat(row-1,col,2));
                    if(bawah && row+1 < 10 && mapTebakan[row+1][col] == 0) kemungkinan.add(new Kordinat(row+1, col,2));
                    if(kiri && col-1 >=0 && mapTebakan[row][col-1] == 0)kemungkinan.add(new Kordinat(row, col-1,2));
                    if(kanan && col+1 < 10 && mapTebakan[row][col+1] == 0) kemungkinan.add(new Kordinat(row, col+1,2));                    
                }
            }else {
                
                boolean closing = false;
                
                mapTebakan[row][col]= 2;
                if(row-1 >=0 && mapTebakan[row-1][col] == 1){
                    
                    if((row-2 < 0 || mapTebakan[row-2][col] == 2 || mapTebakan[row-2][col] == 3) &&(col-1 <0 || mapTebakan[row-1][col-1] == 2 || mapTebakan[row-1][col-1] == 3) && (col+1 >=10 || mapTebakan[row-1][col+1] == 2 || mapTebakan[row-1][col+1] == 3)) {
                        if(col-1 >=0){
                            if(mapTebakan[row][col-1] != 2)mapTebakan[row][col-1] =3;
                            if(row-2 >=0 && mapTebakan[row-2][col-1] != 2)mapTebakan[row-2][col-1] =3;
                            
                        }
                        if(col+1 <10){
                            if(mapTebakan[row][col+1] !=2)mapTebakan[row][col+1] =3;
                            if(row-2>=0 && mapTebakan[row-2][col+1] != 2)mapTebakan[row-2][col+1] =3;                           
                        }
                    }else if(row-2>=0 && mapTebakan[row-2][col] ==1 && (row-3 <0 || mapTebakan[row-3][col] == 2 || mapTebakan[row-3][col] == 3)){
                        if(col-1 >=0){
                            if(mapTebakan[row][col-1] != 2)mapTebakan[row][col-1] =3;
                            if(mapTebakan[row-1][col-1] != 2)mapTebakan[row-1][col-1] =3;
                            if(mapTebakan[row-2][col-1] != 2)mapTebakan[row-2][col-1] =3;
                            if(row-3 >=0 && mapTebakan[row-3][col-1] != 2)mapTebakan[row-3][col-1] =3;                            
                        }
                        if(col+1 <10){
                            if(mapTebakan[row][col+1] != 2)mapTebakan[row][col+1] =3;
                            if(mapTebakan[row-1][col+1] != 2)mapTebakan[row-1][col+1] =3;
                            if(mapTebakan[row-2][col+1] != 2)mapTebakan[row-2][col+1] =3;
                            if(row-3 >=0 && mapTebakan[row-3][col+1] != 2)mapTebakan[row-3][col+1] =3;                            
                        }                    
                    }else if(row-3>=0 && mapTebakan[row-2][col] == 1 && mapTebakan[row-3][col] ==1 &&(row-4 <0 || mapTebakan[row-4][col] ==2 || mapTebakan[row-4][col] ==3)){
                        if(col-1 >=0){
                            if(mapTebakan[row][col-1] != 2)mapTebakan[row][col-1] =3;
                            if(mapTebakan[row-1][col-1] != 2)mapTebakan[row-1][col-1] =3;
                            if(mapTebakan[row-2][col-1] != 2)mapTebakan[row-2][col-1] =3;
                            if(mapTebakan[row-3][col-1] != 2)mapTebakan[row-3][col-1] =3;
                            if(row-4 >=0 && mapTebakan[row-4][col-1] != 2)mapTebakan[row-4][col-1] =3;                            
                        }
                        if(col+1 <10){
                            if(mapTebakan[row][col+1] != 2)mapTebakan[row][col+1] =3;
                            if(mapTebakan[row-1][col+1] != 2)mapTebakan[row-1][col+1] =3;
                            if(mapTebakan[row-2][col+1] != 2)mapTebakan[row-2][col+1] =3;
                            if(mapTebakan[row-3][col+1] != 2)mapTebakan[row-3][col+1] =3;
                            if(row-4 >=0 && mapTebakan[row-4][col+1] != 2)mapTebakan[row-4][col+1] =3;                            
                        }           
                    }
                    
                }else if(row+1 < 10 && mapTebakan[row+1][col] == 1){
                    
                    if((row+2 >= 10 || mapTebakan[row+2][col] == 2 || mapTebakan[row+2][col] == 3) &&(col-1 <0 || mapTebakan[row+1][col-1] == 2 || mapTebakan[row+1][col-1] == 3  ) && (col+1 >=10 || mapTebakan[row+1][col+1] == 2 || mapTebakan[row+1][col+1] == 3)) {
                        if(col-1 >=0){
                            if(mapTebakan[row][col-1] != 2)mapTebakan[row][col-1] =3;
                            if(row+2 < 10 && mapTebakan[row+2][col-1] != 2)mapTebakan[row+2][col-1] =3;
                            
                        }
                        if(col+1 <10){
                            if(mapTebakan[row][col+1] !=2)mapTebakan[row][col+1] =3;
                            if(row+2 < 10 && mapTebakan[row+2][col+1] != 2)mapTebakan[row+2][col+1] =3;                           
                        }
                    }else if(row+2 < 10 && mapTebakan[row+2][col] ==1 && (row+3 >= 10 || mapTebakan[row+3][col] == 2 || mapTebakan[row+3][col] == 3)){
                        if(col-1 >=0){
                            if(mapTebakan[row][col-1] != 2)mapTebakan[row][col-1] =3;
                            if(mapTebakan[row+1][col-1] != 2)mapTebakan[row+1][col-1] =3;
                            if(mapTebakan[row+2][col-1] != 2)mapTebakan[row+2][col-1] =3;
                            if(row+3 < 10 && mapTebakan[row+3][col-1] != 2)mapTebakan[row+3][col-1] =3;                            
                        }
                        if(col+1 <10){
                            if(mapTebakan[row][col+1] != 2)mapTebakan[row][col+1] =3;
                            if(mapTebakan[row+1][col+1] != 2)mapTebakan[row+1][col+1] =3;
                            if(mapTebakan[row+2][col+1] != 2)mapTebakan[row+2][col+1] =3;
                            if(row+3 < 10 && mapTebakan[row+3][col+1] != 2)mapTebakan[row+3][col+1] =3;                            
                        }                    
                    }else if(row+3 < 10 && mapTebakan[row+2][col] == 1 && mapTebakan[row+3][col] ==1 &&(row+4 >= 10 || mapTebakan[row+4][col] ==2 || mapTebakan[row+4][col] ==3)){
                        if(col-1 >=0){
                            if(mapTebakan[row][col-1] != 2)mapTebakan[row][col-1] =3;
                            if(mapTebakan[row+1][col-1] != 2)mapTebakan[row+1][col-1] =3;
                            if(mapTebakan[row+2][col-1] != 2)mapTebakan[row+2][col-1] =3;
                            if(mapTebakan[row+3][col-1] != 2)mapTebakan[row+3][col-1] =3;
                            if(row+4 <10 && mapTebakan[row+4][col-1] != 2)mapTebakan[row+4][col-1] =3;                            
                        }
                        if(col+1 <10){
                            if(mapTebakan[row][col+1] != 2)mapTebakan[row][col+1] =3;
                            if(mapTebakan[row+1][col+1] != 2)mapTebakan[row+1][col+1] =3;
                            if(mapTebakan[row+2][col+1] != 2)mapTebakan[row+2][col+1] =3;
                            if(mapTebakan[row+3][col+1] != 2)mapTebakan[row+3][col+1] =3;
                            if(row+4 < 10 && mapTebakan[row+4][col+1] != 2)mapTebakan[row+4][col+1] =3;                            
                        }           
                    }
                    
                }else if(col+1 < 10 && mapTebakan[row][col+1] == 1){
                    
                    if((col+2 >= 10 || mapTebakan[row][col+2] == 2 || mapTebakan[row][col+2] == 3) &&(row-1 <0 || mapTebakan[row-1][col+1] == 2 || mapTebakan[row-1][col+1] == 3) && (row+1 >=10 || mapTebakan[row+1][col+1] == 2 || mapTebakan[row+1][col+1] == 3)) {
                        if(row-1 >=0){
                            if(mapTebakan[row-1][col] != 2)mapTebakan[row-1][col] =3;
                            if(col+2 < 10 && mapTebakan[row-1][col+2] != 2)mapTebakan[row-1][col+2] =3;
                            
                        }
                        if(row+1 <10){
                            if(mapTebakan[row+1][col] !=2)mapTebakan[row+1][col] =3;
                            if(col+2 < 10 && mapTebakan[row+1][col+2] != 2)mapTebakan[row+1][col+2] =3;                           
                        }
                    }else if(col+2 < 10 && mapTebakan[row][col+2] ==1 && (col+3 >= 10 || mapTebakan[row][col+3] == 2 || mapTebakan[row][col+3] == 3)){
                        if(row-1 >=0){
                            if(mapTebakan[row-1][col] != 2)mapTebakan[row-1][col] =3;
                            if(mapTebakan[row-1][col+1] != 2)mapTebakan[row-1][col+1] =3;
                            if(mapTebakan[row-1][col+2] != 2)mapTebakan[row-1][col+2] =3;
                            if(col+3 < 10 && mapTebakan[row-1][col+3] != 2)mapTebakan[row-1][col+3] =3;                            
                        }
                        if(row+1 <10){
                            if(mapTebakan[row+1][col] != 2)mapTebakan[row+1][col] =3;
                            if(mapTebakan[row+1][col+1] != 2)mapTebakan[row+1][col+1] =3;
                            if(mapTebakan[row+1][col+2] != 2)mapTebakan[row+1][col+2] =3;
                            if(col+3 < 10 && mapTebakan[row+1][col+3] != 2)mapTebakan[row+1][col+3] =3;                            
                        }                    
                    }else if(col+3 < 10 && mapTebakan[row][col+2] == 1 && mapTebakan[row][col+3] ==1 &&(col+4 >= 10 || mapTebakan[row][col+4] ==2 || mapTebakan[row][col+4] ==3)){
                        if(row-1 >=0){
                            if(mapTebakan[row-1][col] != 2)mapTebakan[row-1][col] =3;
                            if(mapTebakan[row-1][col+1] != 2)mapTebakan[row-1][col+1] =3;
                            if(mapTebakan[row-1][col+2] != 2)mapTebakan[row-1][col+2] =3;
                            if(mapTebakan[row-1][col+3] != 2)mapTebakan[row-1][col+3] =3;
                            if(col+4 <10 && mapTebakan[row-1][col+4] != 2)mapTebakan[row-1][col+4] =3;                            
                        }
                        if(row+1 <10){
                            if(mapTebakan[row+1][col] != 2)mapTebakan[row+1][col] =3;
                            if(mapTebakan[row+1][col+1] != 2)mapTebakan[row+1][col+1] =3;
                            if(mapTebakan[row+1][col+2] != 2)mapTebakan[row+1][col+2] =3;
                            if(mapTebakan[row+1][col+3] != 2)mapTebakan[row+1][col+3] =3;
                            if(col+4 < 10 && mapTebakan[row+1][col+4] != 2)mapTebakan[row+1][col+4] =3;                            
                        }           
                    }
                    
                }else if(col-1 >= 0 && mapTebakan[row][col-1] == 1){
                    
                    if((col-2 < 0 || mapTebakan[row][col-2] == 2 || mapTebakan[row][col-2] == 3) &&(row-1 <0 || mapTebakan[row-1][col-1] == 2 || mapTebakan[row-1][col-1] == 3) && (row+1 >=10 || mapTebakan[row+1][col-1] == 2 || mapTebakan[row+1][col-1] == 3)) {
                        if(row-1 >=0){
                            if(mapTebakan[row-1][col] != 2)mapTebakan[row-1][col] =3;
                            if(col-2 >= 0 && mapTebakan[row-1][col-2] != 2)mapTebakan[row-1][col-2] =3;                            
                        }
                        if(row+1 <10){
                            if(mapTebakan[row+1][col] !=2)mapTebakan[row+1][col] =3;
                            if(col-2 >= 0 && mapTebakan[row+1][col-2] != 2)mapTebakan[row+1][col-2] =3;                           
                        }
                    }else if(col-2 >= 0 && mapTebakan[row][col-2] ==1 && (col-3 < 0 || mapTebakan[row][col-3] == 2 || mapTebakan[row][col-3] == 3)){
                        if(row-1 >=0){
                            if(mapTebakan[row-1][col] != 2)mapTebakan[row-1][col] =3;
                            if(mapTebakan[row-1][col-1] != 2)mapTebakan[row-1][col-1] =3;
                            if(mapTebakan[row-1][col-2] != 2)mapTebakan[row-1][col-2] =3;
                            if(col-3 >= 0 && mapTebakan[row-1][col-3] != 2)mapTebakan[row-1][col-3] =3;                            
                        }
                        if(row+1 <10){
                            if(mapTebakan[row+1][col] != 2)mapTebakan[row+1][col] =3;
                            if(mapTebakan[row+1][col-1] != 2)mapTebakan[row+1][col-1] =3;
                            if(mapTebakan[row+1][col-2] != 2)mapTebakan[row+1][col-2] =3;
                            if(col-3 >=0 && mapTebakan[row+1][col-3] != 2)mapTebakan[row+1][col-3] =3;                            
                        }                    
                    }else if(col-3 >= 0 && mapTebakan[row][col-2] == 1 && mapTebakan[row][col-3] ==1 &&(col-4 < 0 || mapTebakan[row][col-4] ==2 || mapTebakan[row][col-4] ==3)){
                        if(row-1 >=0){
                            if(mapTebakan[row-1][col] != 2)mapTebakan[row-1][col] =3;
                            if(mapTebakan[row-1][col-1] != 2)mapTebakan[row-1][col-1] =3;
                            if(mapTebakan[row-1][col-2] != 2)mapTebakan[row-1][col-2] =3;
                            if(mapTebakan[row-1][col-3] != 2)mapTebakan[row-1][col-3] =3;
                            if(col-4 >= 0 && mapTebakan[row-1][col-4] != 2)mapTebakan[row-1][col-4] =3;                            
                        }
                        if(row+1 <10){
                            if(mapTebakan[row+1][col] != 2)mapTebakan[row+1][col] =3;
                            if(mapTebakan[row+1][col-1] != 2)mapTebakan[row+1][col-1] =3;
                            if(mapTebakan[row+1][col-2] != 2)mapTebakan[row+1][col-2] =3;
                            if(mapTebakan[row+1][col-3] != 2)mapTebakan[row+1][col-3] =3;
                            if(col-4 >= 0 && mapTebakan[row+1][col-4] != 2)mapTebakan[row+1][col-4] =3;                            
                        }           
                    }                    
                }
                hit = false;
            }
        }else {
            int row, col;
            do{
                Random rnd = new Random();
                row = rnd.nextInt(10);
                col = rnd.nextInt(10);
            }while(mapTebakan[row][col] != 0);
            System.out.println("Menembak di ("+(row+1)+","+(col+1)+")");
            if(mapMusuh[row][col] == 1){
                hit = true;
                mapTebakan[row][col] = 1;
                if(row-1 >=0 && mapTebakan[row-1][col]!= 2 && mapTebakan[row-1][col] != 3)kemungkinan.add(new Kordinat(row-1,col,1));
                if(row+1 < 10 && mapTebakan[row+1][col]!= 2 && mapTebakan[row+1][col] != 3) kemungkinan.add(new Kordinat(row+1, col,1));
                if(col-1 >=0 && mapTebakan[row][col-1]!= 2 && mapTebakan[row][col-1] != 3)kemungkinan.add(new Kordinat(row, col-1,1));
                if(col+1 < 10&& mapTebakan[row][col+1]!= 2 && mapTebakan[row][col+1]!=3) kemungkinan.add(new Kordinat(row, col+1,1));                
            }else {
                mapTebakan[row][col] = 2;
                hit = false;
            }
        }
    
        //cetakKemungkinan(kemungkinan);
        sortKemungkinan(kemungkinan);
        //cetakKemungkinan(kemungkinan);
        return hit;
    }

    public void removeKordinat(ArrayList<Kordinat> kemungkinan, int row, int col) {
        for (int ii = 0; ii < kemungkinan.size(); ++ii) {
            if (kemungkinan.get(ii).x == row && kemungkinan.get(ii).y == col) {
                kemungkinan.remove(ii);
            }
        }
    }
    
    
    public Kordinat randomKemungkinan(ArrayList<Kordinat> kemungkinan){
        Random rnd = new Random();
        int size2 = 1;
       if(kemungkinan.get(0).priority == kemungkinan.get(kemungkinan.size()-1).priority){
            return kemungkinan.get(rnd.nextInt(kemungkinan.size()));
        }else {
            for(int ii = 0; ii < kemungkinan.size(); ++ii){
                if(kemungkinan.get(ii).priority == 1){
                    size2 = ii;
                    break;
                }
            }
            return kemungkinan.get(rnd.nextInt(size2));
        }
    }
    
       public void sortKemungkinan(ArrayList<Kordinat> kemungkinan) {
        if (!kemungkinan.isEmpty()) {
            Kordinat max = kemungkinan.get(0);
            int indeks = 0;
            for (int ii = 0; ii < kemungkinan.size(); ++ii) {
                max = kemungkinan.get(ii);
                indeks = ii;
                for (int jj = ii + 1; jj < kemungkinan.size(); ++jj) {
                    if (kemungkinan.get(jj).priority > max.priority) {
                        max = kemungkinan.get(jj);
                        indeks = jj;
                    }
                }
                kemungkinan.add(indeks, kemungkinan.get(ii));
                kemungkinan.remove(indeks + 1);
                kemungkinan.add(ii, max);
                kemungkinan.remove(ii + 1);
            }
        }
    }
    public void cetakKemungkinan(ArrayList<Kordinat> k){
        for(Kordinat element:k){
            System.out.print("("+element.x+","+element.y+ ") ");
        }
        System.out.println();
    }
}

class Kordinat {

    int x, y;

    int priority;
    Kordinat(int a, int b, int c) {
        x = a;
        y = b;
        priority = c;
    }
} 
