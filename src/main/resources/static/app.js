
/* global System */

var app = angular.module('myapp', ['ngRoute', 'angular-storage']);
app.config(function ($routeProvider, $locationProvider) {

    $routeProvider
            .when("/", {
                templateUrl: '/home.html'
            }).when("/register", {
        templateUrl: "/register.html",
        controller: "registerController"
    }).when("/login", {
        templateUrl: "/login.html",
        controller: "loginController"
    }).when("/products", {
        templateUrl: "/products.html",
        controller: "productController"
    }).when("/admin", {
        templateUrl: "/admin.html",
        controller: "adminController"
    }).when("/addProduct", {
        templateUrl: "/addProduct.html",
        controller: "productController"
//    }).when("/cart", {
//        templateUrl: "/cart.html",
//        controller: "productController"
    }).when("/adminProducts", {
        templateUrl: "/adminProducts",
        controller: "productController"
    }).when("/usersList", {
        templateUrl: "/usersList",
        controller: "adminController"
    }).when("/checkout", {
        templateUrl: "/checkout.html",
        controller: "productController"
    }).when("/supplier", {
        templateUrl: "/supplier.html",
        controller: "productController"
    }).when("/driver", {
        templateUrl: "/driver.html",
        controller: "adminController"
    }).when("/customerOrder", {
        templateUrl: "/customerOrder.html",
        controller: "productController"
    }).when("/guest", {
        templateUrl: "/guest.html",
        controller: "productController"
    }).when("/updateProduct", {
        templateUrl: "/updateProduct.html",
        controller: "productController"
    }).when("/viewOrder", {
        templateUrl: "/viewOrder.html",
        controller: "productController"

    }).otherwise({
        redirectTo: ("/")
    });
    $locationProvider.html5Mode(false);
});


app.controller('registerController', function ($scope, $http, $location, $rootScope) {

    $scope.register = function () {
        var templateUrl = "/register";
        var user = $scope.user;
        $http.post(templateUrl, user).then(successCallback, errorCallback);
        function successCallback(response) {
            $rootScope.user = user;
            $location.url("/login");
            alert(user.firstname + " " + "You have Successfully Registered, Click OK to login");
        }
        function errorCallback(response) {
            $location.url("/register");
            alert(response.data.status);
        }
    };
});


app.controller('loginController', function ($http, $scope, $location, store, $rootScope) {
    $scope.login = function () {

        $http({
            url: '/login/user',
            method: 'GET',
            params: {username: $scope.username, password: $scope.password}
        }).then(successCallback, errorCallback);
        function successCallback(respose) {
            var user = respose.data;
            var admin = respose.data;
            var supplier = respose.data;
            var driver = respose.data;
            localStorage.setItem("user", JSON.stringify(user.id));
            //             store.set("UserLoggedIn",customer.username);
            if ($scope.username === "admin") {
                alert("Successfully Logged In");
                ;
                $location.url('/admin');
            } else {
                if ($scope.username === "supplier") {
                    alert("Successfully Logged In");
                    ;
                    $location.url('/supplier');
                } else {
                    if ($scope.username === "driver") {
                        alert("Successfully Logged In");
                        ;
                        $location.url('/driver');
                    } else {
                        if ($scope.username === user.username) {
                            alert("Successfully Logged In");
                            $location.url('/products');
                        } else {
                            alert("Invalid Credentials,Please try again");
                            $location.url('/login');
                        }
                    }
                }

            }
        }
        ;
        function errorCallback(response) {
            console.log(response);
            alert("Invalid Credentials,Please try again");
            $location.url('/login');
        }
        ;
    };
});


app.controller('logoutController', function ($location, $session) {
    $session.clear();
    $location.url("/login");
});
app.controller('adminController', function ($http, $scope, $location, $rootScope, $filter) {
    $http.get("/users/all").then(function (response) {
        $scope.users = response.data;
    });
    $http.get("/products/all").then(function (response) {
        $scope.products = response.data;
    });
    $http.get("/customerOrder/all").then(function (response) {
        $scope.customerOrder = response.data;
    });

});
app.controller('productController', function ($http, $scope, $location, $rootScope, $filter) {

    $http.defaults.headers.post["Content-Type"] = "application/json";
    var url = '/addProduct';
    $scope.saveProd = function () {
        var file = document.getElementById('fileItem');
        var iname = file.files.item(0).name;
        //alert($scope.image);
        $http.post(url, {
            name: $scope.name,
            description: $scope.description,
            price: $scope.price,
            category: $scope.category,
            prod_quantity: $scope.prod_quantity,
            batchQuantity: $scope.batchQuantity,
            threshholdQty: $scope.threshholdQty,
            bQuantity: $scope.bQuantity,
            image: iname

        }).then(successCallback, errorCallback);
        function successCallback(response) {
            alert("Product Added Successfully");
            console.log(response.data);
            $location.url('/admin');
        }
        function errorCallback(response) {
            console.log(response);
            alert("failed to add Product");
        }
        ;
    };








    //Update
    $scope.redirectToUpdate = function (prod) {
//        alert(JSON.stringify(prod));
        $rootScope.editProduct = prod;
        $location.url('/updateProduct');
    };
    $scope.updateProduct = function (newProdData) {

        $http.post("/updateProduct", newProdData).then(function (map) {
            alert("Product Successfully Updated");
        });
    };


    //update Product Quantity
    $scope.updateQuantity = function (prod) {
        var threshholdQty = prod.threshholdQty;
        var prod_quantity = prod.prod_quantity;
//        var batchQuantity = prod.batchQuantity + prod.prod_quantity;


        var prod_quantity = prod.threshholdQty + prod.prod_quantity;
        prod.prod_quantity = prod_quantity;


        var batch = prod.bQuantity;
        prod.batchQuantity = batch + prod.batchQuantity;




        $http.post("/supplier", prod).then(function (response) {
            console.log(response.data);
            alert("Quantity Successfully Updated");

        });

if (prod.prod_quantity ===  prod.threshholdQty)
        {
            var threshholdQty = prod_quantity;
            prod.threshholdQty = threshholdQty;

                alert("product has reached the quantity stock");

        } else {

            var threshholdQty = threshholdQty;
            prod.threshholdQty = threshholdQty;

                alert("update");

        }
        ;

//       if (prod_quantity ===prod.threshholdQty)
//       {
//      var threshholdQty = prod_quantity;
//      prod.threshholdQty = threshholdQty;
//
//           $http.post("/supplier", prod).then(function (map) {
//                alert("product has reached the quantity stock");
//
//           });
//
//
//    } else {
//
//
//               $http.post("/supplier", prod).then(function (response) {
//                  console.log(response.data);
//                   alert("hey");
//             });
//      }
//           ;

    };

    $scope.thresh = function (prod) {
        if (prod.prod_quantity ===  prod.threshholdQty)
        {
            var threshholdQty = prod_quantity;
            prod.threshholdQty = threshholdQty;

                alert("product has reached the quantity stock");

        } else {

            var threshholdQty = prod_quantity;
            prod.threshholdQty = threshholdQty;

                alert("product has reached the quantity stock");

        }
        ;
    };



    /**Retrieving Products from the Database**/
    $http.get("/products/all").then(function (response) {
        $scope.products = response.data;
    });
    $http.get("/delivery/all").then(function (response) {
        $scope.delivery = response.data;
    });


//Cart function.....
    $scope.cart = [];
    $scope.total = 0;
    var quantity = $scope.quantity;
    var prod_quantity = $scope.prod_quantity;
    $scope.addToCart = function (prod) {
        if ($scope.cart.length === 0) {


            prod.quantity = 1;
            $scope.cart.push(prod);

//           console.log($scope.cart);
        } else {
            for (var i = 0; i < $scope.cart.length; i++) {
                if ($scope.cart[i].product_id === prod.product_id) {
                    alert("Product Already Added,You can update its Quantity on your list");
//                    $scope.total += parseFloat(prod.price);
                    break;
                } else {
                    //alert("not found in cart list");
                    $scope.cart.push(prod);
                    prod.quantity = 1;

                    break;
                    $scope.total += parseFloat(prod.price);
                }
            }
        }
        localStorage.setItem("carts", JSON.stringify($scope.cart));

        $scope.total += parseFloat(prod.price);

        localStorage.setItem("quantity", JSON.stringify(prod.quantity));
        localStorage.setItem("total", JSON.stringify($scope.total));
        console.log(localStorage.getItem("cartData"));
    };



    ////Removes product from shopping cart///
    $scope.remove = function (prodInCart) {
        var cart = JSON.parse(localStorage.getItem("carts"));
        var cartTotal = JSON.parse(localStorage.getItem("total"));
        var newTotal = cartTotal - prodInCart.price;
        var indexOfProd = cart.findIndex(i => i.name === prodInCart.name);

        // delete cart[indexOfProd];

        $scope.total = newTotal;
        $scope.cart.pop(indexOfProd);

        localStorage.setItem("total", JSON.stringify($scope.total));

    };




//delete products from admin database
    $scope.deleteProd = function (prod)
    {
        alert('Your have permanently deleted an item.');
        var name = prod.name;
        console.log(name);
        $http.get('/deleteProd/' + name).then(function (response) {
            console.log(response);
            if (response.data !== 0)
            {
                alert("Product has been Deleted.");
                location.reload(true);
            } else {

                alert("Product Not Deleted..!!!");
                location.reload(true);
            }

        });

    };

//delete order
    $scope.deleteOrder = function (order)
    {
        alert('Your have permanently deleted infor.');
        var orderId = order.orderId;

        console.log(orderId);
        $http.get('/deleteOrder/' + orderId).then(function (response) {
            console.log(response);
//            if (response.data !== 0)
//            {
//                alert("Data has been Deleted.");
//                location.reload(true);
//            } else {
//
//                alert("Data Not Deleted..!!!");
//                location.reload(true);
//            }

        });
    };



//reload shopping cart list and removes products///
    $scope.reload = function () {
        location.reload(true);
    };

//restrict guest customers from adding to cart//
    $scope.guests = function (prod) {

        alert("You need to login to add products!! Click Ok to login/register.");
        $location.url("/login");
    };



///decrement quantity in shopping cart 
    $scope.removeProdCart = function (prod) {
        if (prod.quantity > 1) {
            prod.quantity -= 1;
            localStorage.setItem("quantity", JSON.stringify(prod.quantity));
        } else if (prod.quantity === 0) {
            var index = $scope.cart.indexOf(prod);
            $scope.cart.splice(index, 1);
        }
        $scope.total -= parseFloat(prod.price);

        localStorage.setItem("total", JSON.stringify($scope.total));

    };

////Increment Quantity in shopping cart
    $scope.incrementQuantity = function (prod) {
        var originalQty = prod.prod_quantity;


        prod.quantity += 1;
        $scope.total += parseFloat(prod.price);

        localStorage.setItem("total", JSON.stringify($scope.total));
        localStorage.setItem("quantity", JSON.stringify(prod.quantity));

        if (originalQty < prod.quantity) {
            alert("The selected quantity exceeds stock");

        } else {


            var newQty = originalQty - prod.quantity;
//            var newQt = newQty - prod.quantity;
            prod.prod_quantity = newQty;
//            prod.batchQuantity = newQt - prod.batchQuantity;

            $http.post("/updateProduct", prod).then(function (map) {
            });

//            $http.post("/supplier", prod).then(function (response) {
//                console.log(response.data);
//            });
//            var threshholdQty = prod_quantity;
//            prod.threshholdQty = threshholdQty;
//            

        }
        ;

    };






////delivery function
//    $http.defaults.headers.post["Content-Type"] = "application/json";
//    var url = '/delivery';
//    $scope.deliver = function () {
//
//
//        $http.post(url, {
//            deliveryId = $scope.deliveryId,
//            province = $scope.deliver.province,
//            city = $scope.city,
//            houseNo = $scope.houseNo,
//            street = $scope.street
//
//        }).then(successCallback, errorCallback);
//        function successCallback(response) {
//            alert("Click Ok to continue");
////            $rootScope.deliver = response.data;
//        }
//        function errorCallback(response) {
//            alert("failed");
//            console.log(response.data);
//        }
//        ;
//
//    };


////Make purchase 
    $scope.placeOrder = function () {

        var orderData = {
            'userId': localStorage.getItem("user"),
            'price': localStorage.getItem("total"),
//            'productCopy': localStorage.getItem("cartData"),
            'bankDetailId': localStorage.getItem("bankDetail"),
            'deliveryId': localStorage.getItem("deliveryId"),
            'quantity': localStorage.getItem("quantity"),
            'status': 'proccessing',
            'orderedDate': $filter('date')(new Date(), 'yyyy-MM-dd')
        };

        console.log(orderData);

        $http({
            url: '/placeOrder',
            method: "POST",
            data: orderData,
            headers: {
                'Content-Type': 'application/json;charset=utf-8;'
            }
        }).then(successCallback, errorCallback);
        function successCallback(response) {
            alert("Congradulations ,Your Order has been placed Successfully ");
            $rootScope.order = response.data;
            $location.url("/products");

        }
        function errorCallback(response) {
            alert("failed");
            console.log(response.data);
        }
        ;

    };




    $scope.makePayment = function () {
        $http({
            url: '/pay',
            method: 'GET',
            params: {
                'bankType': $scope.bank.bankType,
                'accNo': $scope.bank.accNo,
                'pin': $scope.bank.passW
            }
        }).then(successCallBack, errorCallBack);
        function successCallBack(response) {
            if ($scope.bankType === bankType) {
                localStorage.setItem("bankDetail", JSON.stringify($scope.bankDetailId));
                console.log(localStorage.getItem("bankDetail"));
            }
            ;
        }
        ;
        function errorCallBack(response) {
            if ($scope.bankType === 0) {
                console.log(response);
                alert("No bank details");
            }
            ;
        }
        ;
    };



    $scope.checkOut = function () {
        $rootScope.itemsNum = $rootScope.cartItems.length;
        $scope.placeOrder();
    };
    $http.get("/customerOrder/all").then(function (response) {
        $scope.customerOrder = response.data;
    });





    // update status order using order id     
    $scope.updateStatus = function (status)
    {
        $http.put('/customerOrder/updateStatus').then(function (response) {
            console.log(response);
            if (response.data !== 0)
            {
                alert("Order status has been updated");
            }
        }).catch(function (error) {
            alert(error.data.message);
//              alert("hey");
        });
    };

});




app.controller('driverController', function ($http, $scope) {
    $http.get("/customerOrder/all").then(function (response) {
        $scope.customerOrder = response.data;
    });
});


app.controller('supplierController', function ($http, $scope) {

    $http.get("/products/all").then(function (response) {
        $scope.products = response.data;
    });
});

