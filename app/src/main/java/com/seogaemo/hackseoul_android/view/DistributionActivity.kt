package com.seogaemo.hackseoul_android.view

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.seogaemo.hackseoul_android.adapter.JobHistoryAdapter
import com.seogaemo.hackseoul_android.adapter.TableAdapter
import com.seogaemo.hackseoul_android.data.JobHistory
import com.seogaemo.hackseoul_android.data.Table
import com.seogaemo.hackseoul_android.databinding.ActivityDistributionBinding
import com.seogaemo.hackseoul_android.util.BaseActivity
import com.seogaemo.hackseoul_android.util.SpacingItemDecoration

class DistributionActivity : BaseActivity() {
    private lateinit var binding: ActivityDistributionBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDistributionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.backButton.setOnClickListener {
            finish()
        }

        binding.distributionList.apply {
            this.layoutManager = LinearLayoutManager(this@DistributionActivity)
            this.adapter = TableAdapter(
                listOf(
                    Table("연락처", "010-0000-0000"),
                    Table("E-mail", "dayoung048@naver.com"),
                    Table("사업장소재지", "경기도 의정부시 산단로68번길 51\n용현동"),
                    Table("통신판매 신고번호", "제2023-의정부송산-0233호"),
                    Table("사업장번호", "397-85-02404"),
                )
            )
            this.addItemDecoration(SpacingItemDecoration())
        }

        binding.jobHistoryList.apply {
            this.layoutManager = LinearLayoutManager(this@DistributionActivity)
            this.adapter = JobHistoryAdapter(
                listOf(
                    JobHistory("이러쿵저러쿵어쩌구저쩌구", "오늘은 정말 특별한 날이에요. 아침부터 해가 눈부시게 빛나고, 새들의 지저귐 소리가 어느 때보다도 경쾌하게 들려오네요. 이런 날은 밖으로 나가서 산책을 하거나, 좋아하는 카페에서 차를 마시며 책을 읽는 것도 좋을 것 같아요. 사람들의 웃는 얼굴을 보면 마음까지 환해지는 기분이 들어요. 일상의 소소한 행복을 찾는 것, 그것이 바로 우리가 살아가는 이유 아닐까요? 때로는 바쁜 일상 속에서 잠시 멈춰 서서 주변을 둘러보는 여유를 갖는 것도 중요해요. 그 속에서 새로운 영감을 얻거나, 잊고 있던 행복을 다시 찾을 수 있으니까요."),
                    JobHistory("이러쿵저러쿵어쩌구저쩌구", "오늘은 정말 특별한 날이에요. 아침부터 해가 눈부시게 빛나고, 새들의 지저귐 소리가 어느 때보다도 경쾌하게 들려오네요. 이런 날은 밖으로 나가서 산책을 하거나, 좋아하는 카페에서 차를 마시며 책을 읽는 것도 좋을 것 같아요. 사람들의 웃는 얼굴을 보면 마음까지 환해지는 기분이 들어요. 일상의 소소한 행복을 찾는 것, 그것이 바로 우리가 살아가는 이유 아닐까요? 때로는 바쁜 일상 속에서 잠시 멈춰 서서 주변을 둘러보는 여유를 갖는 것도 중요해요. 그 속에서 새로운 영감을 얻거나, 잊고 있던 행복을 다시 찾을 수 있으니까요."),
                )
            )
        }
    }
}