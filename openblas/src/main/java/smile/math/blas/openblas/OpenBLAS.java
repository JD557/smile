/*******************************************************************************
 * Copyright (c) 2010-2020 Haifeng Li. All rights reserved.
 *
 * Smile is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation, either version 3 of
 * the License, or (at your option) any later version.
 *
 * Smile is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with Smile.  If not, see <https://www.gnu.org/licenses/>.
 ******************************************************************************/

package smile.math.blas.openblas;

import smile.math.blas.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.indexer.*;
import static org.bytedeco.openblas.global.openblas.*;

/**
 * OpenBLAS library wrapper.
 *
 * @author Haifeng Li
 */
public class OpenBLAS implements BLAS, LAPACK {
    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(OpenBLAS.class);

    @Override
    public double asum(int n, double[] x, int incx) {
        return cblas_dasum(n, x, incx);
    }

    @Override
    public float asum(int n, float[] x, int incx) {
        return cblas_sasum(n, x, incx);
    }

    @Override
    public void axpy(int n, double alpha, double[] x, int incx, double[] y, int incy) {
        cblas_daxpy(n, alpha, x, incx, y, incy);
    }

    @Override
    public void axpy(int n, float alpha, float[] x, int incx, float[] y, int incy) {
        cblas_saxpy(n, alpha, x, incx, y, incy);
    }

    @Override
    public double dot(int n, double[] x, int incx, double[] y, int incy) {
        return cblas_ddot(n, x, incx, y, incy);
    }

    @Override
    public float dot(int n, float[] x, int incx, float[] y, int incy) {
        return cblas_sdot(n, x, incx, y, incy);
    }

    @Override
    public double nrm2(int n, double[] x, int incx) {
        return cblas_dnrm2(n, x, incx);
    }

    @Override
    public float nrm2(int n, float[] x, int incx) {
        return cblas_snrm2(n, x, incx);
    }

    @Override
    public void scal(int n, double alpha, double[] x, int incx) {
        cblas_dscal(n, alpha, x, incx);
    }

    @Override
    public void scal(int n, float alpha, float[] x, int incx) {
        cblas_sscal(n, alpha, x, incx);
    }

    @Override
    public void swap(int n, double[] x, int incx, double[] y, int incy) {
        cblas_dswap(n, x, incx, y, incy);
    }

    @Override
    public void swap(int n, float[] x, int incx, float[] y, int incy) {
        cblas_sswap(n, x, incx, y, incy);
    }

    @Override
    public long iamax(int n, double[] x, int incx) {
        return cblas_idamax(n, x, incx);
    }

    @Override
    public long iamax(int n, float[] x, int incx) {
        return cblas_isamax(n, x, incx);
    }

    @Override
    public void gemv(Layout layout, Transpose trans, int m, int n, double alpha, double[] A, int lda, double[] x, int incx, double beta, double[] y, int incy) {
        cblas_dgemv(layout.getValue(), trans.getValue(), m, n, alpha, A, lda, x, incx, beta, y, incy);
    }

    @Override
    public void gemv(Layout layout, Transpose trans, int m, int n, float alpha, float[] A, int lda, float[] x, int incx, float beta, float[] y, int incy) {
        cblas_sgemv(layout.getValue(), trans.getValue(), m, n, alpha, A, lda, x, incx, beta, y, incy);
    }

    @Override
    public void symv(Layout layout, UPLO uplo, int n, double alpha, double[] A, int lda, double[] x, int incx, double beta, double[] y, int incy) {
        cblas_dsymv(layout.getValue(), uplo.getValue(), n, alpha, A, lda, x, incx, beta, y, incy);
    }

    @Override
    public void symv(Layout layout, UPLO uplo, int n, float alpha, float[] A, int lda, float[] x, int incx, float beta, float[] y, int incy) {
        cblas_ssymv(layout.getValue(), uplo.getValue(), n, alpha, A, lda, x, incx, beta, y, incy);
    }

    @Override
    public void spmv(Layout layout, UPLO uplo, int n, double alpha, double[] A, double[] x, int incx, double beta, double[] y, int incy) {
        cblas_dspmv(layout.getValue(), uplo.getValue(), n, alpha, A, x, incx, beta, y, incy);
    }

    @Override
    public void spmv(Layout layout, UPLO uplo, int n, float alpha, float[] A, float[] x, int incx, float beta, float[] y, int incy) {
        cblas_sspmv(layout.getValue(), uplo.getValue(), n, alpha, A, x, incx, beta, y, incy);
    }

    @Override
    public void trmv(Layout layout, UPLO uplo, Transpose trans, Diag diag, int n, double[] A, int lda, double[] x, int incx) {
        cblas_dtrmv(layout.getValue(), uplo.getValue(), trans.getValue(), diag.getValue(), n, A, lda, x, incx);
    }

    @Override
    public void trmv(Layout layout, UPLO uplo, Transpose trans, Diag diag, int n, float[] A, int lda, float[] x, int incx) {
        cblas_strmv(layout.getValue(), uplo.getValue(), trans.getValue(), diag.getValue(), n, A, lda, x, incx);
    }

    @Override
    public void tpmv(Layout layout, UPLO uplo, Transpose trans, Diag diag, int n, double[] A, double[] x, int incx) {
        cblas_dtpmv(layout.getValue(), uplo.getValue(), trans.getValue(), diag.getValue(), n, A, x, incx);
    }

    @Override
    public void tpmv(Layout layout, UPLO uplo, Transpose trans, Diag diag, int n, float[] A, float[] x, int incx) {
        cblas_stpmv(layout.getValue(), uplo.getValue(), trans.getValue(), diag.getValue(), n, A, x, incx);
    }

    @Override
    public void gbmv(Layout layout, Transpose trans, int m, int n, int kl, int ku, double alpha, double[] A, int lda, double[] x, int incx, double beta, double[] y, int incy) {
        cblas_dgbmv(layout.getValue(), trans.getValue(), m, n, kl, ku, alpha, A, lda, x, incx, beta, y, incy);
    }

    @Override
    public void gbmv(Layout layout, Transpose trans, int m, int n, int kl, int ku, float alpha, float[] A, int lda, float[] x, int incx, float beta, float[] y, int incy) {
        cblas_sgbmv(layout.getValue(), trans.getValue(), m, n, kl, ku, alpha, A, lda, x, incx, beta, y, incy);
    }

    @Override
    public void sbmv(Layout layout, UPLO uplo, int n, int k, double alpha, double[] A, int lda, double[] x, int incx, double beta, double[] y, int incy) {
        cblas_dsbmv(layout.getValue(), uplo.getValue(), n, k, alpha, A, lda, x, incx, beta, y, incy);
    }

    @Override
    public void sbmv(Layout layout, UPLO uplo, int n, int k, float alpha, float[] A, int lda, float[] x, int incx, float beta, float[] y, int incy) {
        cblas_ssbmv(layout.getValue(), uplo.getValue(), n, k, alpha, A, lda, x, incx, beta, y, incy);
    }

    @Override
    public void ger(Layout layout, int m, int n, double alpha, double[] x, int incx, double[] y, int incy, double[] A, int lda) {
        cblas_dger(layout.getValue(), m, n, alpha, x, incx, y, incy, A, lda);
    }

    @Override
    public void ger(Layout layout, int m, int n, float alpha, float[] x, int incx, float[] y, int incy, float[] A, int lda) {
        cblas_sger(layout.getValue(), m, n, alpha, x, incx, y, incy, A, lda);
    }

    @Override
    public void syr(Layout layout, UPLO uplo, int n, double alpha, double[] x, int incx, double[] A, int lda) {
        cblas_dsyr(layout.getValue(), uplo.getValue(), n, alpha, x, incx, A, lda);
    }

    @Override
    public void syr(Layout layout, UPLO uplo, int n, float alpha, float[] x, int incx, float[] A, int lda) {
        cblas_ssyr(layout.getValue(), uplo.getValue(), n, alpha, x, incx, A, lda);
    }

    @Override
    public void spr(Layout layout, UPLO uplo, int n, double alpha, double[] x, int incx, double[] A) {
        cblas_dspr(layout.getValue(), uplo.getValue(), n, alpha, x, incx, A);
    }

    @Override
    public void spr(Layout layout, UPLO uplo, int n, float alpha, float[] x, int incx, float[] A) {
        cblas_sspr(layout.getValue(), uplo.getValue(), n, alpha, x, incx, A);
    }

    @Override
    public void gemm(Layout layout, Transpose transA, Transpose transB, int m, int n, int k, double alpha, double[] A, int lda, double[] B, int ldb, double beta, double[] C, int ldc) {
        cblas_dgemm(layout.getValue(), transA.getValue(), transB.getValue(), m, n, k, alpha, A, lda, B, ldb, beta, C, ldc);
    }

    @Override
    public void gemm(Layout layout, Transpose transA, Transpose transB, int m, int n, int k, float alpha, float[] A, int lda, float[] B, int ldb, float beta, float[] C, int ldc) {
        cblas_sgemm(layout.getValue(), transA.getValue(), transB.getValue(), m, n, k, alpha, A, lda, B, ldb, beta, C, ldc);
    }

    @Override
    public void symm(Layout layout, Side side, UPLO uplo, int m, int n, double alpha, double[] A, int lda, double[] B, int ldb, double beta, double[] C, int ldc) {
        cblas_dsymm(layout.getValue(), side.getValue(), uplo.getValue(), m, n, alpha, A, lda, B, ldb, beta, C, ldc);
    }

    @Override
    public void symm(Layout layout, Side side, UPLO uplo, int m, int n, float alpha, float[] A, int lda, float[] B, int ldb, float beta, float[] C, int ldc) {
        cblas_ssymm(layout.getValue(), side.getValue(), uplo.getValue(), m, n, alpha, A, lda, B, ldb, beta, C, ldc);
    }

    @Override
    public int gesv(Layout layout, int n, int nrhs, double[] A, int lda, int[] ipiv, double[] B, int ldb) {
        return LAPACKE_dgesv(layout.getValue(), n, nrhs, A, lda, ipiv, B, ldb);
    }

    @Override
    public int gesv(Layout layout, int n, int nrhs, float[] A, int lda, int[] ipiv, float[] B, int ldb) {
        return LAPACKE_sgesv(layout.getValue(), n, nrhs, A, lda, ipiv, B, ldb);
    }

    @Override
    public int sysv(Layout layout, UPLO uplo, int n, int nrhs, double[] A, int lda, int[] ipiv, double[] B, int ldb) {
        return LAPACKE_dsysv(layout.getValue(), uplo.getValue(), n, nrhs, A, lda, ipiv, B, ldb);
    }

    @Override
    public int sysv(Layout layout, UPLO uplo, int n, int nrhs, float[] A, int lda, int[] ipiv, float[] B, int ldb) {
        return LAPACKE_ssysv(layout.getValue(), uplo.getValue(), n, nrhs, A, lda, ipiv, B, ldb);
    }

    @Override
    public int spsv(Layout layout, UPLO uplo, int n, int nrhs, double[] A, int[] ipiv, double[] B, int ldb) {
        return LAPACKE_dspsv(layout.getValue(), uplo.getValue(), n, nrhs, A, ipiv, B, ldb);
    }

    @Override
    public int spsv(Layout layout, UPLO uplo, int n, int nrhs, float[] A, int[] ipiv, float[] B, int ldb) {
        return LAPACKE_sspsv(layout.getValue(), uplo.getValue(), n, nrhs, A, ipiv, B, ldb);
    }

    @Override
    public int posv(Layout layout, UPLO uplo, int n, int nrhs, double[] A, int lda, double[] B, int ldb) {
        return LAPACKE_dposv(layout.getValue(), uplo.getValue(), n, nrhs, A, lda, B, ldb);
    }

    @Override
    public int posv(Layout layout, UPLO uplo, int n, int nrhs, float[] A, int lda, float[] B, int ldb) {
        return LAPACKE_sposv(layout.getValue(), uplo.getValue(), n, nrhs, A, lda, B, ldb);
    }

    @Override
    public int ppsv(Layout layout, UPLO uplo, int n, int nrhs, double[] A, double[] B, int ldb) {
        return LAPACKE_dppsv(layout.getValue(), uplo.getValue(), n, nrhs, A, B, ldb);
    }

    @Override
    public int ppsv(Layout layout, UPLO uplo, int n, int nrhs, float[] A, float[] B, int ldb) {
        return LAPACKE_sppsv(layout.getValue(), uplo.getValue(), n, nrhs, A, B, ldb);
    }

    @Override
    public int gbsv(Layout layout, int n, int kl, int ku, int nrhs, double[] A, int lda, int[] ipiv, double[] B, int ldb) {
        return LAPACKE_dgbsv(layout.getValue(), n, kl, ku, nrhs, A, lda, ipiv, B, ldb);
    }

    @Override
    public int gbsv(Layout layout, int n, int kl, int ku, int nrhs, float[] A, int lda, int[] ipiv, float[] B, int ldb) {
        return LAPACKE_sgbsv(layout.getValue(), n, kl, ku, nrhs, A, lda, ipiv, B, ldb);
    }

    @Override
    public int gels(Layout layout, Transpose trans, int m, int n, int nrhs, double[] A, int lda, double[] B, int ldb) {
        return LAPACKE_dgels(layout.getValue(), trans.getValue(), m, n, nrhs, A, lda, B, ldb);
    }

    @Override
    public int gels(Layout layout, Transpose trans, int m, int n, int nrhs, float[] A, int lda, float[] B, int ldb) {
        return LAPACKE_sgels(layout.getValue(), trans.getValue(), m, n, nrhs, A, lda, B, ldb);
    }

    @Override
    public int gelsy(Layout layout, int m, int n, int nrhs, double[] A, int lda, double[] B, int ldb, int[] jpvt, double rcond, int[] rank) {
        return LAPACKE_dgelsy(layout.getValue(), m, n, nrhs, A, lda, B, ldb, jpvt, rcond, rank);
    }

    @Override
    public int gelsy(Layout layout, int m, int n, int nrhs, float[] A, int lda, float[] B, int ldb, int[] jpvt, float rcond, int[] rank) {
        return LAPACKE_sgelsy(layout.getValue(), m, n, nrhs, A, lda, B, ldb, jpvt, rcond, rank);
    }

    @Override
    public int gelss(Layout layout, int m, int n, int nrhs, double[] A, int lda, double[] B, int ldb, double[] s, double rcond, int[] rank) {
        return LAPACKE_dgelss(layout.getValue(), m, n, nrhs, A, lda, B, ldb, s, rcond, rank);
    }

    @Override
    public int gelss(Layout layout, int m, int n, int nrhs, float[] A, int lda, float[] B, int ldb, float[] s, float rcond, int[] rank) {
        return LAPACKE_sgelss(layout.getValue(), m, n, nrhs, A, lda, B, ldb, s, rcond, rank);
    }

    @Override
    public int gelsd(Layout layout, int m, int n, int nrhs, double[] A, int lda, double[] B, int ldb, double[] s, double rcond, int[] rank) {
        return LAPACKE_dgelsd(layout.getValue(), m, n, nrhs, A, lda, B, ldb, s, rcond, rank);
    }

    @Override
    public int gelsd(Layout layout, int m, int n, int nrhs, float[] A, int lda, float[] B, int ldb, float[] s, float rcond, int[] rank) {
        return LAPACKE_sgelsd(layout.getValue(), m, n, nrhs, A, lda, B, ldb, s, rcond, rank);
    }

    @Override
    public int gglse(Layout layout, int m, int n, int p, double[] A, int lda, double[] B, int ldb, double[] c, double[] d, double[] x) {
        return LAPACKE_dgglse(layout.getValue(), m, n, p, A, lda, B, ldb, c, d, x);
    }

    @Override
    public int gglse(Layout layout, int m, int n, int p, float[] A, int lda, float[] B, int ldb, float[] c, float[] d, float[] x) {
        return LAPACKE_sgglse(layout.getValue(), m, n, p, A, lda, B, ldb, c, d, x);
    }

    @Override
    public int ggglm(Layout layout, int n, int m, int p, double[] A, int lda, double[] B, int ldb, double[] d, double[] x, double[] y) {
        return LAPACKE_dggglm(layout.getValue(), n, m, p, A, lda, B, ldb, d, x, y);
    }

    @Override
    public int ggglm(Layout layout, int n, int m, int p, float[] A, int lda, float[] B, int ldb, float[] d, float[] x, float[] y) {
        return LAPACKE_sggglm(layout.getValue(), n, m, p, A, lda, B, ldb, d, x, y);
    }
}