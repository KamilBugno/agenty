var world = [{x: 7.0, y: 4.0, width: 3.0, height: 4.0},{x: 4.0, y: 0.0, width: 4.0, height: 4.0},{x: 0.0, y: 0.0, width: 4.0, height: 4.0},{x: 0.0, y: 4.0, width: 7.0, height: 4.0},];
var steps = [
[35.0, 25.0, 40.0, 5.0, ],
[34.9, 25.0, 39.8, 5.2, ],
[34.8, 25.1, 39.7, 5.4, ],
[34.7, 25.1, 39.5, 5.7, ],
[34.6, 25.2, 39.4, 5.9, ],
[34.5, 25.2, 39.2, 6.1, ],
[34.4, 25.2, 39.0, 6.3, ],
[34.3, 25.3, 38.9, 6.5, ],
[34.2, 25.3, 38.7, 6.8, ],
[34.1, 25.4, 38.6, 7.0, ],
[34.0, 25.4, 38.4, 7.2, ],
[33.9, 25.4, 38.2, 7.4, ],
[33.8, 25.5, 38.1, 7.6, ],
[33.7, 25.5, 37.9, 7.9, ],
[33.6, 25.6, 37.8, 8.1, ],
[33.5, 25.6, 37.6, 8.3, ],
[33.4, 25.6, 37.4, 8.5, ],
[33.3, 25.7, 37.3, 8.7, ],
[33.2, 25.7, 37.1, 9.0, ],
[33.1, 25.8, 37.0, 9.2, ],
[33.0, 25.8, 36.8, 9.4, ],
[32.9, 25.8, 36.6, 9.6, ],
[32.8, 25.9, 36.5, 9.8, ],
[32.7, 25.9, 36.3, 10.1, ],
[32.6, 26.0, 36.2, 10.3, ],
[32.5, 26.0, 36.0, 10.5, ],
[32.4, 26.0, 35.8, 10.7, ],
[32.3, 26.1, 35.7, 10.9, ],
[32.2, 26.1, 35.5, 11.2, ],
[32.1, 26.2, 35.4, 11.4, ],
[32.0, 26.2, 35.2, 11.6, ],
[31.9, 26.2, 35.0, 11.8, ],
[31.8, 26.3, 34.9, 12.0, ],
[31.7, 26.3, 34.7, 12.3, ],
[31.6, 26.4, 34.6, 12.5, ],
[31.5, 26.4, 34.4, 12.7, ],
[31.4, 26.4, 34.2, 12.9, ],
[31.3, 26.5, 34.1, 13.1, ],
[31.2, 26.5, 33.9, 13.4, ],
[31.1, 26.6, 33.8, 13.6, ],
[31.0, 26.6, 33.6, 13.8, ],
[30.9, 26.6, 33.4, 14.0, ],
[30.8, 26.7, 33.3, 14.2, ],
[30.7, 26.7, 33.1, 14.5, ],
[30.6, 26.8, 33.0, 14.7, ],
[30.5, 26.8, 32.8, 14.9, ],
[30.4, 26.8, 32.6, 15.1, ],
[30.3, 26.9, 32.5, 15.3, ],
[30.2, 26.9, 32.3, 15.6, ],
[30.1, 27.0, 32.2, 15.8, ],
[30.0, 27.0, 32.0, 16.0, ],
[29.9, 27.0, 31.8, 16.2, ],
[29.8, 27.1, 31.7, 16.4, ],
[29.7, 27.1, 31.5, 16.7, ],
[29.6, 27.2, 31.4, 16.9, ],
[29.5, 27.2, 31.2, 17.1, ],
[29.4, 27.2, 31.0, 17.3, ],
[29.3, 27.3, 30.9, 17.5, ],
[29.2, 27.3, 30.7, 17.8, ],
[29.1, 27.4, 30.6, 18.0, ],
[29.0, 27.4, 30.4, 18.2, ],
[28.9, 27.4, 30.2, 18.4, ],
[28.8, 27.5, 30.1, 18.6, ],
[28.7, 27.5, 29.9, 18.9, ],
[28.6, 27.6, 29.8, 19.1, ],
[28.5, 27.6, 29.6, 19.3, ],
[28.4, 27.6, 29.4, 19.5, ],
[28.3, 27.7, 29.3, 19.7, ],
[28.2, 27.7, 29.1, 20.0, ],
[28.1, 27.8, 29.0, 20.2, ],
[28.0, 27.8, 28.8, 20.4, ],
[27.9, 27.8, 28.6, 20.6, ],
[27.8, 27.9, 28.5, 20.8, ],
[27.8, 27.9, 28.3, 21.1, ],
[27.7, 27.9, 28.2, 21.3, ],
[27.6, 27.9, 28.0, 21.5, ],
[27.6, 27.9, 27.8, 21.7, ],
[27.5, 27.7, 27.8, 21.9, ],
[27.5, 27.7, 27.7, 22.2, ],
[27.4, 27.5, 27.7, 22.4, ],
[27.3, 27.5, 27.5, 22.6, ],
[27.3, 27.4, 27.5, 22.8, ],
[27.2, 27.4, 27.4, 23.0, ],
[27.2, 27.2, 27.4, 23.3, ],
[27.1, 27.2, 27.2, 23.5, ],
[27.0, 27.1, 27.2, 23.7, ],
[27.0, 27.1, 27.0, 23.9, ],
[26.9, 26.9, 27.0, 24.1, ],
[26.9, 26.9, 26.9, 24.4, ],
[26.8, 26.7, 26.9, 24.6, ],
[26.7, 26.8, 26.7, 24.8, ],
[26.7, 26.6, 26.7, 25.0, ],
[26.6, 26.6, 26.6, 25.2, ],
[26.5, 26.5, 26.6, 25.5, ],
[26.4, 26.4, 26.5, 25.7, ],
[26.4, 26.3, 26.4, 25.9, ],
[26.3, 26.3, 26.3, 26.1, ],
[26.2, 26.3, 26.2, 26.2, ],
[26.3, 26.2, 26.3, 26.2, ],
[26.3, 26.2, 26.2, 26.2, ],
[26.2, 26.3, 26.2, 26.2, ],
];