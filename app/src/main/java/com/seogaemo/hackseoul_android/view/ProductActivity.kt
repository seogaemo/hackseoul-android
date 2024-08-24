package com.seogaemo.hackseoul_android.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.seogaemo.hackseoul_android.adapter.DistributionAdapter
import com.seogaemo.hackseoul_android.adapter.TableAdapter
import com.seogaemo.hackseoul_android.data.Distribution
import com.seogaemo.hackseoul_android.data.Table
import com.seogaemo.hackseoul_android.databinding.ActivityProductBinding
import com.seogaemo.hackseoul_android.util.BaseActivity
import com.seogaemo.hackseoul_android.util.SpacingItemDecoration

class ProductActivity : BaseActivity() {
    private lateinit var binding: ActivityProductBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.backButton.setOnClickListener {
            finish()
        }

        binding.productList.apply {
            this.layoutManager = LinearLayoutManager(this@ProductActivity)
            this.adapter = TableAdapter(
                listOf(
                    Table("모델 번호", "A1230FSD25"),
                    Table("제조일자", "2024. 00. 00"),
                )
            )
            this.addItemDecoration(SpacingItemDecoration())
        }

        binding.sellerList.apply {
            this.layoutManager = LinearLayoutManager(this@ProductActivity)
            this.adapter = TableAdapter(
                listOf(
                    Table("상호/대표자", "주식회사 티디엠리테일 / 김기윤"),
                    Table("연락처", "010-0000-0000"),
                    Table("E-mail", "dayoung048@naver.com"),
                    Table("사업장소재지", "경기도 의정부시 산단로68번길 51\n용현동"),
                    Table("통신판매 신고번호", "제2023-의정부송산-0233호"),
                    Table("사업자번호", "397-85-02404"),
                )
            )
            this.addItemDecoration(SpacingItemDecoration())
        }

        binding.dbpList.apply {
            this.layoutManager = LinearLayoutManager(this@ProductActivity)
            this.adapter = DistributionAdapter(
                listOf(
                    Distribution("쿠팡", isCoupang = true),
                    Distribution(),
                    Distribution(),
                    Distribution(),
                    Distribution(),
                )
            )
        }

    }
}