const path = require('path');

module.exports = {
    mode: 'development',
    entry: __dirname + "/src/core.js",
    module:{
        rules:[
            {
                test: /\.js|jsx$/,
                exclude: /node_modules/,
                loader: "babel-loader"
            }
        ]
    },
    output:{
        filename: 'index.js',
        path: path.resolve( __dirname + "/assets/")
    },

    //Including source maps for debugging
    devtool : 'inline-source-maps',

    //Customizing server things
    devServer: {
        contentBase: 'assets',
        historyApiFallback: true
      },

    performance: {
        hints: false,
        maxEntrypointSize: 512000,
        maxAssetSize: 512000
    }

}