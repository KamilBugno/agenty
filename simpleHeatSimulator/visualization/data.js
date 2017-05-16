var world = [{x: 7.0, y: 4.0, width: 1.0, height: 4.0},{x: 4.0, y: 0.0, width: 4.0, height: 4.0},{x: 0.0, y: 0.0, width: 4.0, height: 4.0},{x: 0.0, y: 4.0, width: 7.0, height: 4.0},];
var steps = [
[35.0, 25.0, 40.0, 5.0, ],
[34.6, 25.0, 39.9, 5.1, ],
[34.3, 25.0, 39.7, 5.3, ],
[33.9, 25.0, 39.6, 5.4, ],
[33.6, 25.0, 39.4, 5.5, ],
[33.2, 25.0, 39.3, 5.6, ],
[32.9, 25.0, 39.2, 5.8, ],
[32.5, 25.0, 39.0, 5.9, ],
[32.2, 25.0, 38.9, 6.0, ],
[31.9, 25.0, 38.8, 6.1, ],
[31.6, 25.1, 38.6, 6.2, ],
[31.3, 25.1, 38.5, 6.4, ],
[31.0, 25.1, 38.4, 6.5, ],
[30.7, 25.1, 38.2, 6.6, ],
[30.4, 25.1, 38.1, 6.7, ],
[30.1, 25.1, 38.0, 6.8, ],
[29.8, 25.1, 37.8, 6.9, ],
[29.5, 25.1, 37.7, 7.0, ],
[29.3, 25.1, 37.6, 7.2, ],
[29.0, 25.1, 37.5, 7.3, ],
[28.7, 25.1, 37.4, 7.4, ],
[28.5, 25.1, 37.2, 7.5, ],
[28.2, 25.1, 37.1, 7.6, ],
[28.0, 25.1, 37.0, 7.7, ],
[27.7, 25.1, 36.9, 7.8, ],
[27.5, 25.1, 36.8, 7.9, ],
[27.3, 25.1, 36.6, 8.0, ],
[27.0, 25.1, 36.5, 8.1, ],
[26.8, 25.1, 36.4, 8.2, ],
[26.6, 25.1, 36.3, 8.3, ],
[26.4, 25.1, 36.2, 8.4, ],
[26.2, 25.1, 36.1, 8.5, ],
[26.0, 25.0, 36.0, 8.6, ],
[25.8, 25.0, 35.9, 8.7, ],
[25.6, 25.0, 35.7, 8.8, ],
[25.4, 25.0, 35.6, 8.8, ],
[25.2, 25.0, 35.5, 8.9, ],
[25.0, 25.0, 35.4, 9.0, ],
[24.8, 25.0, 35.3, 9.1, ],
[24.6, 25.0, 35.2, 9.2, ],
[24.5, 25.0, 35.1, 9.3, ],
[24.3, 25.0, 35.0, 9.4, ],
[24.1, 25.0, 34.9, 9.5, ],
[24.0, 25.0, 34.8, 9.5, ],
[23.8, 25.0, 34.7, 9.6, ],
[23.6, 25.0, 34.6, 9.7, ],
[23.5, 25.0, 34.5, 9.8, ],
[23.3, 25.0, 34.4, 9.9, ],
[23.2, 25.0, 34.3, 10.0, ],
[23.0, 25.0, 34.2, 10.0, ],
[22.9, 25.0, 34.1, 10.1, ],
[22.8, 24.9, 34.0, 10.2, ],
[22.6, 24.9, 33.9, 10.3, ],
[22.5, 24.9, 33.8, 10.3, ],
[22.3, 24.9, 33.7, 10.4, ],
[22.2, 24.9, 33.7, 10.5, ],
[22.1, 24.9, 33.6, 10.6, ],
[22.0, 24.9, 33.5, 10.6, ],
[21.8, 24.9, 33.4, 10.7, ],
[21.7, 24.9, 33.3, 10.8, ],
[21.6, 24.9, 33.2, 10.9, ],
[21.5, 24.9, 33.1, 10.9, ],
[21.4, 24.9, 33.0, 11.0, ],
[21.3, 24.8, 32.9, 11.1, ],
[21.2, 24.8, 32.9, 11.1, ],
[21.1, 24.8, 32.8, 11.2, ],
[21.0, 24.8, 32.7, 11.3, ],
[20.9, 24.8, 32.6, 11.4, ],
[20.8, 24.8, 32.5, 11.4, ],
[20.7, 24.8, 32.4, 11.5, ],
[20.6, 24.8, 32.4, 11.6, ],
[20.5, 24.8, 32.3, 11.6, ],
[20.4, 24.8, 32.2, 11.7, ],
[20.3, 24.8, 32.1, 11.7, ],
[20.2, 24.7, 32.0, 11.8, ],
[20.1, 24.7, 32.0, 11.9, ],
[20.1, 24.7, 31.9, 11.9, ],
[20.0, 24.7, 31.8, 12.0, ],
[19.9, 24.7, 31.7, 12.1, ],
[19.8, 24.7, 31.6, 12.1, ],
[19.8, 24.7, 31.6, 12.2, ],
[19.7, 24.7, 31.5, 12.2, ],
[19.6, 24.7, 31.4, 12.3, ],
[19.5, 24.6, 31.3, 12.4, ],
[19.5, 24.6, 31.3, 12.4, ],
[19.4, 24.6, 31.2, 12.5, ],
[19.3, 24.6, 31.1, 12.5, ],
[19.3, 24.6, 31.1, 12.6, ],
[19.2, 24.6, 31.0, 12.6, ],
[19.2, 24.6, 30.9, 12.7, ],
[19.1, 24.6, 30.8, 12.7, ],
[19.0, 24.6, 30.8, 12.8, ],
[19.0, 24.5, 30.7, 12.9, ],
[18.9, 24.5, 30.6, 12.9, ],
[18.9, 24.5, 30.6, 13.0, ],
[18.8, 24.5, 30.5, 13.0, ],
[18.8, 24.5, 30.4, 13.1, ],
[18.7, 24.5, 30.4, 13.1, ],
[18.7, 24.5, 30.3, 13.2, ],
[18.6, 24.5, 30.2, 13.2, ],
[18.6, 24.5, 30.2, 13.3, ],
];
