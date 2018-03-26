
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
    }).when("/cart", {
        templateUrl: "/cart.html",
        controller: "productController"
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
    }).when("/requestProduct", {
        templateUrl: "/requestProduct.html",
        controller: "stockController"
    }).when("/stock", {
        templateUrl: "/stock.html",
        controller: "stockController"
   }).when("/suppliedStock", {
        templateUrl: "/suppliedStock.html",
        controller: "stockController"
   }).when("/delivery", {
        templateUrl: "/delivery.html",
        controller: "productController"
}).when("/addProd", {
        templateUrl: "/addProd.html",
        controller: "adminController"
        
        
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
                }  else {
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

    $http.get("/stock/all").then(function (response) {
        $scope.stock = response.data;

    });
    
    $http.get("/delivery/all").then(function (response) {
        $scope.delivery = response.data;
    });
    
  
    
    //update customer view by sending the products to product view
        $scope.redirectToView = function (stock) {
        alert(JSON.stringify(stock));
        $rootScope.editProd = stock;
        $location.url('/addProd');
    };

    $scope.updateProd = function (newProdData) {

        $http.post("/addProduct", newProdData).then(function (map) {
            alert("Product Successfully Updated");
            $location.url('/admin');
            

        });
    };
    
  
    
  //delete products from admin database
    $scope.deleteStock = function (stock)
    {
        alert('Your have permanently deleted an item!!');
        var name = stock.name;
        console.log(name);
        $http.get('/deleteStock/' + name).then(function (response) {
            console.log(response);
            if (response.data !== 0)
            {
                alert("Product has been Deleted from stock.");
                location.reload(true);
            } else {

                alert("Product Not Deleted..!!!");
                location.reload(true);
            }

        });

    };
    
    
     $http.defaults.headers.post["Content-Type"] = "application/json";
    var url = '/admin';

    $scope.createProd = function () {
        var file = document.getElementById('fileItem');
        var iname = file.files.item(0).name;

        //alert($scope.image);
        $http.post(url, {
            name: $scope.name,
            description: $scope.description,
            price: $scope.price,
            category: $scope.category,
//            prod_quantity: $scope.prod_quantity,
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
//            prod_quantity: $scope.prod_quantity,
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
    $scope.addToCart = function (prod) {
        if ($scope.cart.length === 0) {
            prod.quantity = 1;
            $scope.cart.push(prod);

//           console.log($scope.cart);
        } else {
            for (var i = 0; i < $scope.cart.length; i++) {
                if ($scope.cart[i].product_id === prod.product_id) {
                    alert("Product Already Added,You can update its Quantity on your list");
                    break;
                } else {
                    //alert("not found in cart list");
                    $scope.cart.push(prod);
                    prod.quantity = 1;

                    break;
                }
            }
        }
        localStorage.setItem("carts", JSON.stringify($scope.cart));

        $scope.total += parseFloat(prod.price);

        localStorage.setItem("quantity", JSON.stringify(prod.quantity));
        localStorage.setItem("total", JSON.stringify($scope.total));
//        console.log( localStorage.getItem("cartData"));
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
    
    
    //delete delivery details from admin database
    $scope.deleteSt = function (delivery_id)
    {
        alert('Your have permanently deleted infor.');
        var name = delivery_id.delivery_id;
        console.log(name);
        $http.get('/deleteSt/' + delivery_id).then(function (response) {
            console.log(response);
            if (response.data !== 0)
            {
                alert("Data has been Deleted.");
                location.reload(true);
            } else {

                alert("Data Not Deleted..!!!");
                location.reload(true);
            }

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
        } else if (prod.quantity === 1) {
            var index = $scope.cart.indexOf(prod);
            $scope.cart.splice(index, 1);
        }
        $scope.total -= parseFloat(prod.price);

        localStorage.setItem("total", JSON.stringify($scope.total));
    };

////Increment Quantity in shopping cart
    $scope.incrementQuantity = function (prod) {
        prod.quantity += 1;
        $scope.total += parseFloat(prod.price);

        localStorage.setItem("total", JSON.stringify($scope.total));
        localStorage.setItem("quantity", JSON.stringify(prod.quantity));

    };

//delivery function
    $scope.deliver = function () {

        var orderData = {
            'delivery_id': localStorage.getItem("delivery"),
            'province': localStorage.getItem($scope.province),
            'city': localStorage.getItem($scope.city),
            'houseNo': localStorage.getItem($scope.houseNo),
            'street': localStorage.getItem($scope.street)
            
        };
        
        console.log(orderData);

        $http({
            url: '/deliver',
            method: "POST",
            data: orderData,
            headers: {
                'Content-Type': 'application/json;charset=utf-8;'
            }
        }).then(successCallback, errorCallback);
        function successCallback(response) {
            alert("Click Ok to continue");
            $rootScope.delivery = response.data;
        }
        function errorCallback(response) {
            alert("failed");
            console.log(response.data);
        }
        ;

    };




////Make purchase 
    $scope.placeOrder = function () {

        var orderData = {
            'userId': localStorage.getItem("user"),
            'price': localStorage.getItem("total"),
            'productCopy': localStorage.getItem("cartData"),
            'bankDetailId': localStorage.getItem("bankDetail"),
            'quantity': localStorage.getItem("quantity"),
            'status': 'proccessing Delivery',
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
                'pin': $scope.bank.pin
            }
        }).then(successCallBack, errorCallBack);
        function successCallBack(response) {
            if ($scope.bankType === bankType) {
                localStorage.setItem("bankDetail", JSON.stringify($scope.bank.id));
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
    
    
     $scope.redirectToView = function (stock) {
//        alert(JSON.stringify(stock));
        $rootScope.editProd = stock;
        $location.url('/addProd');
    };

    $scope.updateProd = function (newProdData) {

        $http.post("/addProd", newProdData).then(function (map) {
            alert("Product Successfully Updated");
            $location.url('/products');

        });
    };
    
      // update status order using order id     
     $scope.updateStatus = function(orderId, status)
         {
             $http.put('/customerOrder/updateStatus/' + orderId + '/' + status + '').then(function(response){
                console.log(response);
                if(response.data !== 0)
                {
                 alert("Order status has been updated");
                }
	 }).catch(function (error){
//             alert(error.data.message);
              alert("hey");
         });
             
         }  ;
         
         
         
    
});


app.controller('driverController', function ($http, $scope) {
 $http.get("/customerOrder/all").then(function (response) {
  $scope.customerOrder= response.data;
  
    });
     });


app.controller('supplierController', function ($http, $scope) {
 $http.get("/stock/all").then(function (response) {
  $scope.stock = response.data;
    });
    
    $http.get("/stock/all").then(function (response) {
  $scope.stock = response.data;
    });
     });
     

app.controller('stockController', function ($http, $scope, $location, $rootScope, $filter) {

    $http.defaults.headers.post["Content-Type"] = "application/json";
    var url = '/rest-controller/requestProduct';

    $scope.saveQuest = function () {
        var file = document.getElementById('fileItem');
        var iname = file.files.item(0).name;

        // alert($scope.image);
        $http.post(url, {
            name: $scope.name,
            description: $scope.description,
            category: $scope.category,
             price: $scope.price,
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



///Retrieves products from stock 
    $http.get("/stock/all").then(function (response) {
        $scope.stock = response.data;

    });

   //Update
    $scope.redirectToSupply = function (stock) {
//        alert(JSON.stringify(stock));
        $rootScope.editProduct = stock;
        $location.url('/suppliedStock');
    };

    $scope.supplyStock = function (newProdData) {

        $http.post("/suppliedStock", newProdData).then(function (map) {
            alert("Product Successfully Updated");
            $location.url('/stock');

        });
    };

 $scope.reload = function (stock) {
        location.reload(true);
    };


});

