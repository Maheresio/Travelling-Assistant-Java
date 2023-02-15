package com.example.travellingassistant;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class ProductsRepository {

    private ProductsDao productsDao;

    private LiveData<List<Products>>getAllProducts;

    public ProductsRepository(Application app) {
        ProductRoomDb db=ProductRoomDb.getInstance(app);
        productsDao=db.productsDao();
        getAllProducts=productsDao.getAllProducts();
    }

    public void insert (Products product) { new InsertAsyncTask(productsDao).execute(product);}
    public void update (Products product) {new UpdateAsyncTask(productsDao).execute(product);}
    public void delete (Products product) { new DeleteAsyncTask(productsDao).execute(product);}
    public LiveData<List<Products>> getGetAllProducts () {return getAllProducts;}
    public void deleteAllProducts() {new DeleteAllProductsAsyncTask(productsDao).execute();}

    private static class InsertAsyncTask extends AsyncTask<Products,Void,Void>
    {
        public ProductsDao productsDao;

        public InsertAsyncTask(ProductsDao productsDao) {
            this.productsDao = productsDao;
        }

        @Override
        protected Void doInBackground(Products... products) {
            productsDao.insert(products[0]);
            return null;
        }
    }
    private static class DeleteAsyncTask extends AsyncTask<Products,Void,Void>
    {
        public ProductsDao productsDao;

        public DeleteAsyncTask(ProductsDao productsDao) {
            this.productsDao = productsDao;
        }

        @Override
        protected Void doInBackground(Products... products) {
            productsDao.delete(products[0]);
            return null;
        }
    }
    private static class UpdateAsyncTask extends AsyncTask<Products,Void,Void>
    {
        public ProductsDao productsDao;

        public UpdateAsyncTask(ProductsDao productsDao) {
            this.productsDao = productsDao;
        }

        @Override
        protected Void doInBackground(Products... products) {
            productsDao.update(products[0]);
            return null;
        }
    }
    private static class DeleteAllProductsAsyncTask extends AsyncTask<Void,Void,Void>
    {
        public ProductsDao productsDao;

        public DeleteAllProductsAsyncTask(ProductsDao productsDao) {
            this.productsDao = productsDao;
        }


        @Override
        protected Void doInBackground(Void... voids) {
            productsDao.deleteAllProducts();
            return null;
        }
    }
}
