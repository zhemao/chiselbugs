module BlackBoxA (
    input        clk,
    input        rst,
    output [3:0] to,
    input  [3:0] from
);
    reg [3:0] store;

    always @(posedge clk) begin
        if (rst)
            store <= 4'h0;
        else
            store <= from;
    end

    assign to = store ^ 4'hc;
endmodule

module BlackBoxB (
    input        clk,
    input        rst,
    output [3:0] to,
    input  [3:0] from
);
    reg [3:0] store;

    always @(posedge clk) begin
        if (rst)
            store <= 4'h0;
        else
            store <= from;
    end

    assign to = store + 1'b1;
endmodule
