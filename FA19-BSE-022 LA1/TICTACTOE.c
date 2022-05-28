#include <stdio.h>

#include <stdlib.h>

char body[3][3];

char check(void);

void initialize_matrix(void);

void player_move(void);

void comp_move(void);

void display(void);


int main(void)

{

    char flag;

    printf("This is the game of Tic Tac Toe.\n");

    printf("You will be playing against the computer.\n");

    flag = ' ';

    initialize_matrix();

    do {

    display();

    player_move();

    flag = check();

    if(flag!= ' ')
        break;

    comp_move();

    flag = check();

    } while(flag== ' ');

    if(flag=='X')
        printf("You won!\n");

    else
        printf("Computer won!!!!\n");

    display();

    return 0;

}
void initialize_matrix(void)

{

    int i, j;

    for(i=0; i<3; i++)

    for(j=0; j<3; j++)
        body[i][j] = ' ';

}

void player_move(void)

{

    int x, y;

    printf("Enter X,Y coordinates for your move: ");

    scanf("%d%*c%d", &x, &y);

    x--;
    y--;

    if(body[x][y]!= ' '){

    printf("Invalid move, try again.\n");

    player_move();

}

    else
        body[x][y] = 'X';

}

void comp_move(void)

{

    int i, j;

    for(i=0; i<3; i++){

    for(j=0; j<3; j++)

    if(body[i][j]==' ')
        break;

    if(body[i][j]==' ')
        break;

}

    if(i*j==9) {

    printf("draw\n");

    exit(0);

}

else
    body[i][j] = 'O';

}

void display(void)
{

    int i;

    for(i=0; i<3; i++) {

    printf(" %c | %c | %c ",body[i][0],body[i][1], body [i][2]);

    if(i!=2)
        printf("\n---|---|---\n");

    }

    printf("\n");

}

char check(void)
{

    int i;

    for(i=0; i<3; i++)

    if(body[i][0]==body[i][1] && body[i][0]==body[i][2])
        return body[i][0];

    for(i=0; i<3; i++)

    if(body[0][i]==body[1][i] && body[0][i]==body[2][i])
        return body[0][i];

    if(body[0][0]==body[1][1] && body[1][1]==body[2][2])
        return body[0][0];

    if(body[0][2]==body[1][1] && body[1][1]==body[2][0])
        return body[0][2];

    return ' ';

}
